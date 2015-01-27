import time

__author__ = 'ant6'
#!/usr/bin/python
# -*- coding: utf-8 -*-

from Tkinter import *
from numpy import arange, sin, pi
import tkFileDialog
import tkFont
import tkMessageBox
from matplotlib.backends.backend_tkagg import FigureCanvasTkAgg
from matplotlib.figure import Figure
from py4j.java_gateway import JavaGateway, GatewayClient


# set to True for debug messages
from py4j.protocol import Py4JJavaError, Py4JNetworkError

debug = True
show_buttons = True
hideSet = []

gatewayPort = 25336

emasValues = {"numberOfAgents": 50,
              "dimensions": 1,
              "iterations": 1000,
              "energyLossFactor": 1,
              "numberOfIslands": 2,
              "energyOnStart": 50,
              "minEnergy": 1,
              "genotypeRandomnessFactor": 0.7,
              "iterationStat": 10,
              }

window = Tk()
winWid = int(window.winfo_screenwidth() * 0.8)
winHei = int(window.winfo_screenheight() * 0.8)

buttonXPos = winWid * 0.75
labelXPos = buttonXPos  # -100
labelYPos = -20
buttonYPos = winHei * 0.85

# font for labels etc.
labelFont = tkFont.Font(family="Georgia", size=14)

# plotting
f = Figure(dpi=100)
plota = f.add_subplot(111)
dataPlot = FigureCanvasTkAgg(f, master=window)
dataPoints = []

def spanBasicLabels(wrapper):
    '''
    Labels for starting window
    :return:
    '''
    basicLabelSett = {"font": labelFont, "width": 30, "anchor": W, "wraplength": "500"}

    basicLabelSett["text"] = "Iterations:"
    paramIterations = Label(wrapper, basicLabelSett, bg=None)
    paramIterations.place(x=labelXPos, y=labelYPos + 30)
    hideSet.append(paramIterations)

    basicLabelSett["text"] = "Agents:"
    paramAgents = Label(wrapper, basicLabelSett, bg=None)
    paramAgents.place(x=labelXPos, y=labelYPos + 90)
    hideSet.append(paramAgents)

    basicLabelSett["text"] = "Dimensions:"
    paramDimensions = Label(wrapper, basicLabelSett, bg=None)
    paramDimensions.place(x=labelXPos, y=labelYPos + 150)
    hideSet.append(paramDimensions)

    basicLabelSett["text"] = "Energy Loss Factor:"
    paramEnergy = Label(wrapper, basicLabelSett, bg=None)
    paramEnergy.place(x=labelXPos, y=labelYPos + 210)
    hideSet.append(paramEnergy)

    basicLabelSett["text"] = "Islands:"
    paramIslands = Label(wrapper, basicLabelSett, bg=None)
    paramIslands.place(x=labelXPos, y=labelYPos + 270)
    hideSet.append(paramIslands)

    basicLabelSett["text"] = "Starting Energy:"
    paramStartEnergy = Label(wrapper, basicLabelSett, bg=None)
    paramStartEnergy.place(x=labelXPos, y=labelYPos + 330)
    hideSet.append(paramStartEnergy)

    basicLabelSett["text"] = "Minimal Energy:"
    paramMinEnergy= Label(wrapper, basicLabelSett, bg=None)
    paramMinEnergy.place(x=labelXPos, y=labelYPos + 390)
    hideSet.append(paramMinEnergy)

    basicLabelSett["text"] = "Genotype Factor:"
    paramGenotype= Label(wrapper, basicLabelSett, bg=None)
    paramGenotype.place(x=labelXPos, y=labelYPos + 450)
    hideSet.append(paramGenotype)

    basicLabelSett["text"] = "Statistics Density:"
    paramStats= Label(wrapper, basicLabelSett, bg=None)
    paramStats.place(x=labelXPos, y=labelYPos + 510)
    hideSet.append(paramStats)


def spanBasicEntries(wrapper):
    '''
    Entries for starting window
    :return:
    '''
    basicEntrySett = {"font": labelFont, "width": "9", "justify": LEFT, "state": "normal", "takefocus": "yes"}
    global entParamIterations, entParamAgents, entParamDimensions, entParamLossEnergy, entParamMinEnergy
    global entParamIslands, entParamStats, entParamStartEnergy, entParamGenotype

    entParamIterations = Entry(wrapper, basicEntrySett)
    entParamIterations.place(x=labelXPos, y=labelYPos + 60)
    hideSet.append(entParamIterations)

    entParamAgents = Entry(wrapper, basicEntrySett)
    entParamAgents.place(x=labelXPos, y=labelYPos + 120)
    hideSet.append(entParamAgents)

    entParamDimensions = Entry(wrapper, basicEntrySett)
    entParamDimensions.place(x=labelXPos, y=labelYPos + 180)
    hideSet.append(entParamDimensions)

    entParamLossEnergy = Entry(wrapper, basicEntrySett)
    entParamLossEnergy.place(x=labelXPos, y=labelYPos + 240)
    hideSet.append(entParamLossEnergy)

    entParamIslands = Entry(wrapper, basicEntrySett)
    entParamIslands.place(x=labelXPos, y=labelYPos + 300)
    hideSet.append(entParamIslands)

    entParamStartEnergy = Entry(wrapper, basicEntrySett)
    entParamStartEnergy.place(x=labelXPos, y=labelYPos + 360)
    hideSet.append(entParamStartEnergy)

    entParamMinEnergy = Entry(wrapper, basicEntrySett)
    entParamMinEnergy.place(x=labelXPos, y=labelYPos + 420)
    hideSet.append(entParamMinEnergy)

    entParamGenotype = Entry(wrapper, basicEntrySett)
    entParamGenotype.place(x=labelXPos, y=labelYPos + 480)
    hideSet.append(entParamGenotype)

    entParamStats = Entry(wrapper, basicEntrySett)
    entParamStats.place(x=labelXPos, y=labelYPos + 540)
    hideSet.append(entParamStats)


def spanBasicButtons(wrapper):
    '''
    Buttons for starting window
    :return:
    '''
    butStart = Button(wrapper, text='Start simulation', command=startCommunication, width=15)
    butStart.place(x=buttonXPos, y=buttonYPos + 30)
    hideSet.append(butStart)

    butLoad = Button(wrapper, text="Load from file", command=showLoadDialog, width=15)
    butLoad.place(x=buttonXPos, y=buttonYPos + 60)
    hideSet.append(butLoad)

    # butTest = Button(wrapper, text="Test connection", command=startCommunication, width=15)
    # butTest.place(x=buttonXPos, y=buttonYPos + 60)
    # hideSet.append(butTest)


def spanBasicGUI(wrapper):
    '''
    Show Basic GUI for starting simulation
    :return:
    '''
    spanBasicLabels(wrapper)
    spanBasicEntries(wrapper)
    spanBasicButtons(wrapper)


def hideBasicGUI():
    '''
    Hiding GUI widgets
    :return:
    '''
    for e in hideSet:
        e.destroy()

def parseInputFile(loadfile):
    '''
    Parsing given file and looking for waned parameters
    :param loadfile:
    :return:
    '''
    f = loadfile.readlines()
    f = [e.strip() for e in f]
    # resetEmasValues()
    wrongVals = ''
    for w in f:
        for q in emasValues.keys():
            if q in w:
                # TODO: Input value check
                temp = ''
                try:
                    temp = w[w.index('=') + 1:]
                    int(temp)
                except (TypeError, ValueError):
                    wrongVals += q + ' '
                emasValues[q] = temp
            elif (wrongVals.find(q) < 0) and (emasValues[q] == '' or emasValues[q] == 0):
                wrongVals += q + ' '

    tkMessageBox.showerror("Load config from file",
                           "Wrong values for:\n\n%s\n\nPlease input them manually or try "
                           "loading from a different file." % wrongVals)
    if debug:
        print emasValues


def showLoadDialog():
    '''
    Shows dialog for humans to choose a file
    :return:
    '''
    loadfile = ''
    try:
        loadfile = tkFileDialog.askopenfile(mode='r')
    except:
        tkMessageBox.showerror("Load from file", "Cannot open given file:\n\n(%s)" % loadfile)
        return
    parseInputFile(loadfile)


def loadParamsFromForm():
    '''
    Loading parameters from entries if they are not empty
    :return:
    '''
    try:
        emasValues['iterations'] = int(entParamIterations.get())
        emasValues['numberOfAgents'] = int(entParamAgents.get())
        emasValues['dimensions'] = int(entParamDimensions.get())
        emasValues['energyLossFactor'] = int(entParamLossEnergy.get())
        emasValues['numberOfIslands'] = int(entParamIslands.get())
        emasValues['energyOnStart'] = int(entParamStartEnergy.get())
        emasValues['minEnergy'] = int(entParamMinEnergy.get())
        emasValues['genotypeRandomnessFactor'] = int(entParamGenotype.get())
        emasValues['iterationStat'] = int(entParamStats.get())
    except:
        print "error while loading from entries"

    #print emasValues


def startCommunication():
    '''
    Testing Py4J connection - will be removed in further versions
    :return:
    '''
    loadParamsFromForm()
    try:
        gateway = JavaGateway(GatewayClient(port=gatewayPort))
        dataStack = gateway.entry_point.getStack()
        tkMessageBox.showinfo("Py4J connection",
                              "Connection successful!")
        startSimulation(dataStack)
    except (Py4JJavaError, Py4JNetworkError):
        tkMessageBox.showerror("Py4J connection",
                               "Wrong port %s or server does not exist at all!" % gatewayPort)


def plotData():
    '''
    Just testing plotting library, will be removed
    :return:
    '''
    hideBasicGUI()

    f.clf()
    plota = f.add_subplot(111)

    t = arange(0, dataPoints.__len__()+1)
    s = dataPoints
    plota.plot(t, s)

    dataPlot.show()
    dataPlot.get_tk_widget().place(x=0, y=0, width=winWid, height=winHei)


def sendParameters(dataStack):
    '''
    Sending parameters to core for simulation
    :param dataStack:
    :return:
    '''
    for k in emasValues.keys():
        try:
            dataStack.push(k + "=" + str(emasValues[k]))
            print k + "=" + str(emasValues[k])
        except (Py4JJavaError, Py4JNetworkError):
            tkMessageBox.showerror("Py4J connection",
                                   "Sending parameters failed")
    

def loadDrawData(dataStack):
    while not dataStack.gui():
        #time.sleep(5)
        print dataStack.getInternalList
    DataToPlot = dataStack.getInternalList
    print DataToPlot
    for e in DataToPlot:
        dataPoints.append(e[e.index('s=')+2:])



def startSimulation(dataStack):
    '''
    Preparing to start simulation and enabling plot update (will be added in future)
    :param dataStack:
    :return:
    '''
    sendParameters(dataStack)
    dataStack.isR()
    loadDrawData(dataStack)
    plotData()


window.protocol("WM_DELETE_WINDOW", lambda: window.destroy())
spanBasicGUI(window)
window.geometry("{0}x{1}+0+0".format(winWid, winHei))

# TODO: updating plot using py4j
# window.after(time_space, updatePlot)

window.mainloop()