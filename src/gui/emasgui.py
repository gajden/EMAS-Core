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

gatewayPort = 25335

emasValues = {"agents": 0,
              "dimensions": 0,
              "leftinterval": 0,
              "rightinterval": 0,
              "iterationspergraph": 0}

window = Tk()
winWid = int(window.winfo_screenwidth() * 0.8)
winHei = int(window.winfo_screenheight() * 0.8)

buttonXPos = winWid * 0.75
labelXPos = buttonXPos  # -100
labelYPos = winHei * 0.25
buttonYPos = winHei * 0.7

# font for labels etc.
labelFont = tkFont.Font(family="Georgia", size=14)

# plotting
f = Figure(dpi=100)
plota = f.add_subplot(111)
dataPlot = FigureCanvasTkAgg(f, master=window)


def spanBasicLabels(wrapper):
    '''
    Labels for starting window
    '''
    basicLabelSett = {"font": labelFont, "width": 30, "anchor": W, "wraplength": "500"}

    basicLabelSett["text"] = "Waiting to start simulation..."
    paramState = Label(wrapper, basicLabelSett, bg=None)
    paramState.place(x=labelXPos - 40, y=labelYPos - 30)
    hideSet.append(paramState)

    basicLabelSett["text"] = "Simulation duration:"
    paramDuration = Label(wrapper, basicLabelSett, bg=None)
    paramDuration.place(x=labelXPos, y=labelYPos + 30)
    hideSet.append(paramDuration)

    basicLabelSett["text"] = "Amount of agents:"
    paramAgents = Label(wrapper, basicLabelSett, bg=None)
    paramAgents.place(x=labelXPos, y=labelYPos + 90)
    hideSet.append(paramAgents)

    basicLabelSett["text"] = "Dimensions:"
    paramDimensions = Label(wrapper, basicLabelSett, bg=None)
    paramDimensions.place(x=labelXPos, y=labelYPos + 150)
    hideSet.append(paramDimensions)

    basicLabelSett["text"] = "More..."
    paramMore = Label(wrapper, basicLabelSett, bg=None)
    paramMore.place(x=labelXPos, y=labelYPos + 210)
    hideSet.append(paramMore)


def spanBasicEntries(wrapper):
    '''
    Entries for starting window
    '''
    basicEntrySett = {"font": labelFont, "width": "9", "justify": LEFT, "state": "normal", "takefocus": "yes"}

    entParamAgents = Entry(wrapper, basicEntrySett)
    entParamAgents.place(x=labelXPos, y=labelYPos + 60)
    hideSet.append(entParamAgents)

    entParamDuration = Entry(wrapper, basicEntrySett)
    entParamDuration.place(x=labelXPos, y=labelYPos + 120)
    hideSet.append(entParamDuration)

    entParamDimensions = Entry(wrapper, basicEntrySett)
    entParamDimensions.place(x=labelXPos, y=labelYPos + 180)
    hideSet.append(entParamDimensions)


def spanBasicButtons(wrapper):
    '''
    Buttons for starting window
    '''
    butStart = Button(wrapper, text='Start simulation', command=plotData, width=15)
    butStart.place(x=buttonXPos, y=buttonYPos + 0)
    hideSet.append(butStart)

    butLoad = Button(wrapper, text="Load from file", command=showLoadDialog, width=15)
    butLoad.place(x=buttonXPos, y=buttonYPos + 30)
    hideSet.append(butLoad)

    butTest = Button(wrapper, text="Test connection", command=startCommunication, width=15)
    butTest.place(x=buttonXPos, y=buttonYPos + 60)
    hideSet.append(butTest)


def spanBasicGUI(wrapper):
    '''
    Show Basic GUI for starting simulation
    '''
    spanBasicLabels(wrapper)
    spanBasicEntries(wrapper)
    spanBasicButtons(wrapper)


def hideBasicGUI():
    for e in hideSet:
        e.destroy()


def resetEmasValues():
    emasValues = {"agents": 0,
                  "dimensions": 0,
                  "leftinterval": 0,
                  "rightinterval": 0,
                  "iterationspergraph": 0}


def parseInputFile(loadfile):
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
            elif (wrongVals.find(q) < 0) and (emasValues[q] == ''):
                wrongVals += q + ' '

    tkMessageBox.showerror("Load config from file",
                           "Wrong values for:\n\n%s\n\nPlease input them manually or try "
                           "loading from a different file." % wrongVals)
    if debug:
        print emasValues


def showLoadDialog():
    loadfile = ''
    try:
        loadfile = tkFileDialog.askopenfile(mode='r')
    except:
        tkMessageBox.showerror("Load from file", "Cannot open given file:\n\n(%s)" % loadfile)
        return
    parseInputFile(loadfile)


def startCommunication():
    '''
    Testing Py4J connection - will be removed in further versions
    '''
    global plottingTable
    try:
        gateway = JavaGateway(GatewayClient(port=gatewayPort))
        dataStack = gateway.entry_point.getStack()
        if dataStack.size > 0:
            plottingTable = dataStack.pop()
        if dataStack.size() == 0:
            dataStack.push("czesc jestem GUI")
        tkMessageBox.showinfo("Py4J connection",
                              "Connection successful! Got data:\n\n %s" % plottingTable)
    except (Py4JJavaError, Py4JNetworkError):
        tkMessageBox.showerror("Py4J connection",
                               "Wrong port %s or server does not exist at all!" % gatewayPort)


def plotData():
    hideBasicGUI()

    f.clf()
    plota = f.add_subplot(111)

    t = arange(0.0, 1.0, 0.01)
    s = sin(2 * pi * t)
    plota.plot(t, s)

    dataPlot.show()
    dataPlot.get_tk_widget().place(x=0, y=0, width=winWid * 0.8, height=winHei)


window.protocol("WM_DELETE_WINDOW", lambda: window.destroy())
spanBasicGUI(window)
window.geometry("{0}x{1}+0+0".format(winWid, winHei))

# TODO: updating plot using py4j
# window.after(time_space, updatePlot)

window.mainloop()
