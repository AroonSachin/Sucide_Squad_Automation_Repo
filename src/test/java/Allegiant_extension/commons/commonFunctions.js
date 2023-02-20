var common = {

    /**
    * Enters text in an input field in a way that React will respond to.
    * Directly setting an input value works, but React will not copy the value to its internal model.
    * The value would disappear if the component is re-rendered, and even if it didn't it would never
    * be submitted in an API request.
    * @param {*} element 
    */
    simulateTextEntry: function (input, text) {
        try {
            const nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;
            nativeInputValueSetter.call(input, text);

            const event = new Event('input', { bubbles: true });
            input.dispatchEvent(event);
            console.log(text + " Enter to the given element ")
        } catch (error) {
            console.error(error)
        }
    },

    /**
     * Clicks the given react element.
     * @param {*} element 
     * @param {*} Log 
     */
    reactClick: function (element, elementName) {
        try {
            const mouseClickEvents = ['mousedown', 'click', 'mouseup'];
            mouseClickEvents.forEach(mouseEventType =>
                element.dispatchEvent(
                    new MouseEvent(mouseEventType, {
                        view: window,
                        bubbles: true,
                        cancelable: true,
                        buttons: 1,
                    }),
                ),
            );
            console.log(elementName + " is clicked")
        } catch (error) {
            console.log(elementName + " not clicked ");
            console.log(error)
            return Error
        }
    },


    elementClick: function (element, elementName) {
        try {
            element.click();
            this.postMsg(elementName + " is clicked ")
        } catch (error) {
            this.errorMsg(elementName + " is not Clicked ")
        }
    },

    /**
     * Prints the message to the console.
     * @param {*} message 
     */
    postMsg: function (message) {
        console.log(message)
    },

    /**
     * Prints the error message to the console. 
     * @param {} errorMessage 
     */
    errorMsg: function (errorMessage) {
        console.error(errorMessage)
    },
    /**
     * Gives an alert message.
     * @param {*} alertMessage 
     */
    alert: function (alertMessage) {
        alert(alertMessage)
    },
    /**
     * @function To scroll to the target element.
     * @param {*} element 
     * @param {*} elementName 
     */
    scrollToElement: function (element, elementName = null) {
        scroll(element)
        if (elementName !== null) {
            console.log("Scrolled to " + elementName)
        }
    },

    /**
     * @Function To hold the execution for the given duration in milliseconds.
     * @param {*} miliseconds 
     */
    hold: function (miliseconds) {
        const currentTime = new Date().getTime();
        console.log(" execution paunsed ")
        while (currentTime + miliseconds >= new Date().getTime()) {

        }
        console.log(" Execution resumed ")
    },
    /**
     * @Function To Wait untill the element appears.
     * @param {*} tab 
     */
    waitUntilLoad: function (tab) {
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {
                while (true) {
                    if (document.readyState === 'complete') {
                        break;
                    } else {
                        console.log('Waiting for the page to finish loading ')
                        common.hold(1000);
                    }
                }
            }
        })
    },
    /**
     * @Function To evaluate and return the locator for the given X-Path.
     * @param {*} path 
     * @returns 
     */
    getElement: function (path) {
        return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    },
    /**
     * @Function Waits for the element and checks for the the element frequently as per given {checkFrequencyInMs} untill the element appears.
     *           If the {timeoutInMs} exceeds the function returns null;
     * @param {*} element 
     * @param {*} callback 
     * @param {*} checkFrequencyInMs 
     * @param {*} timeoutInMs 
     */
    waitForElm: function (element, callback, checkFrequencyInMs, timeoutInMs) {
        var startTimeInMs = Date.now();
        (function loopSearch() {
            if (element != null) {
                callback();
                return;
            }
            else {
                setTimeout(function () {
                    if (timeoutInMs && Date.now() - startTimeInMs > timeoutInMs)
                        return;
                    loopSearch();
                }, checkFrequencyInMs);
            }
        })();
    },
    /**
     * @Function To change the innerText of the gien element.
     * @param {*} elemnt 
     * @param {*} text 
     */
    chageInnerText: function (elemnt, text) {
        try {
            elemnt.innerText = text;
            console.log(text + " Entered ")
        } catch (error) {
            comsole.error(text + " not entered")
        }
    },
    /**
     * @Function To change the flags as per the page.
     * @param {*} page 
     */
    changeFlag: function (page) {
        switch (page) {
            case "Home":
                break;
            case "Flights":
                break;

            case "Bundles":
                flags.flightsFlags.continueFlag = true;
                break;

            case "Travelers":
                flags.BundlesFlag.continueFlag = true;
                break;

            case "Seats":
                flags.TravelerFlags.continueFlag = true;
                break;

            case "Bags and Extras":
                flags.SeatFlags.continueFlag = true;
                break;

            case "Hotels":
                flags.bagsAndExtrasFlags.continueFlag = true;
                break;

            case "Cars":
                flags.HotelsFlags.ContinueFlag = true;
                break;

            case "Cars":
                flags.HotelsFlags.ContinueFlag = true;
                break;

            default:
                alert("No such page")
                break;
        }
    }
};