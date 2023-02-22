var common = {

    /**
    * Enters text in an input field in a way that React will respond to.
    * Directly setting an input value works, but React will not copy the value to its internal model.
    * The value would disappear if the component is re-rendered, and even if it didn't it would never
    * be submitted in an API request.
    * @param {*} element 
    */
    simulateTextEntry: function (input, text) {
        const nativeInputValueSetter = Object.getOwnPropertyDescriptor(window.HTMLInputElement.prototype, 'value').set;
        nativeInputValueSetter.call(input, text);

        const event = new Event('input', { bubbles: true });
        input.dispatchEvent(event);
        console.log(text + " Enter to the given element ")
    },

    /**
     * Clicks the given react element.
     * @param {*} element 
     * @param {*} Log 
     */
    reactClick: function (element, elementName) {
        console.log("Inside function")
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
            console.error(); (" Element not clicked ")
            console.log(error)
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

    scrollToElement: function (element, elementName = null) {
        scroll(element)
        if (elementName !== null) {
            console.log("Scrolled to " + elementName)
        }
    },

    hold: function (miliseconds) {
        const currentTime = new Date().getTime();
        console.log(" execution paunsed ")
        while (currentTime + miliseconds >= new Date().getTime()) {

        }
        console.log(" Execution resumed ")
    },
    waitUntilLoad: function () {
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
    getElement: function (path) {
        return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    }
}

var queryOptions = { active: true, lastFocusedWindow: true };
// `tab` will either be a `tabs.Tab` instance or `undefined`.
var [tab] = await chrome.tabs.query(queryOptions);
chrome.storage.session.set({ tabid: tab.id }).then(() => {
    console.log("Value is set to " + tab.id);
});
chrome.storage.session.get(["tabid"]).then((result) => {
    console.log("Value currently is " + result.tabid);
    var tab = result.tabid
    /*******************************Home Page**************************************************************************** */
    /**
     * @listner navigates to the HomePage and executes the script when the Allegiant_Home button is clicked in the extension PopUp. 
     */
    document.getElementById("Allegiant_Home").addEventListener('click', async function () {

        console.log("in")
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {

                if (document.readyState === 'complete') {
                    var Homeport = chrome.runtime.connect({ name: "homefrompopup" });
                    Homeport.postMessage({ page: document.title + "home" });
                } else {
                     alert('Please let the page to load completely  before continuing')
                }
            }
        })

    })

    /*******************************Flights Page**************************************************************************** */
    /**
     * @listner navigates to the HomePage and executes the script when the Allegiant_Home button is clicked in the extension PopUp. 
     */
    document.getElementById("Flights_Page").addEventListener('click', async function () {

        console.log("in")
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {

                if (document.readyState === 'complete') {
                    var Flightport = chrome.runtime.connect({ name: "flightsfrompopup" });
                    Flightport.postMessage({ page: document.title + "flights" });

                } else {
                     alert('Please let the page to load completely  before continuing')
                }

            }
        })

    })

    /*******************************Bundles Page**************************************************************************** */
    /**
     * @listner navigates to the HomePage and executes the script when the Allegiant_Home button is clicked in the extension PopUp. 
     */
    document.getElementById("Bundles_Page").addEventListener('click', async function () {

        console.log("in")
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {

                if (document.readyState === 'complete') {
                    var Bundlesport = chrome.runtime.connect({ name: "bundlesfrompopup" });
                    Bundlesport.postMessage({ page: document.title + "bundles" });

                } else {
                     alert('Please let the page to load completely  before continuing')
                }

            }
        })

    })

    /*******************************Travelers Page**************************************************************************** */
    /**
     * @listner navigates to the HomePage and executes the script when the Allegiant_Home button is clicked in the extension PopUp. 
     */
    document.getElementById("TravellerDetails").addEventListener('click', async function () {

        console.log("in")
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {

                if (document.readyState === 'complete') {
                    var Travelersport = chrome.runtime.connect({ name: "travelersfrompopup" });
                    Travelersport.postMessage({ page: document.title + "travelers" });

                } else {
                     alert('Please let the page to load completely  before continuing')
                }

            }
        })

    })

    /*******************************Seats Page**************************************************************************** */
    /**
     * @listner navigates to the HomePage and executes the script when the Allegiant_Home button is clicked in the extension PopUp. 
     */
    document.getElementById("seatSelectionPage").addEventListener('click', async function () {
        console.log("in")
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {

                if (document.readyState === 'complete') {
                    var Seatsport = chrome.runtime.connect({ name: "seatPagefrompopup" });
                    Seatsport.postMessage({ page: document.title + "seatPage" });

                } else {
                     alert('Please let the page to load completely  before continuing')
                }

            }
        })

    })

    /*******************************Bags Page**************************************************************************** */
    /**
     * @listner navigates to the HomePage and executes the script when the Allegiant_Home button is clicked in the extension PopUp. 
     */
    document.getElementById("BagsPage").addEventListener('click', async function () {
        console.log("in")
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {

                if (document.readyState === 'complete') {
                    var Bagsport = chrome.runtime.connect({ name: "BagPagefrompopup" });
                    Bagsport.postMessage({ page: document.title + "BagPage" });
                } else {
                     alert('Please let the page to load completely  before continuing')
                }
            }
        })

    })

    /*******************************Hotels Page**************************************************************************** */
    /**
     * @listner navigates to the HomePage and executes the script when the Allegiant_Home button is clicked in the extension PopUp. 
     */
    document.getElementById("HotelsPage").addEventListener('click', async function () {
        console.log("in")
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {

                if (document.readyState === 'complete') {
                    var Hotelsport = chrome.runtime.connect({ name: "hotelsPagefrompopup" });
                    Hotelsport.postMessage({ page: document.title + "hotelsPage" });

                } else {
                     alert('Please let the page to load completely  before continuing')
                }
            }
        })
    })

    /*******************************Cars Page**************************************************************************** */
    /**
     * @listner navigates to the HomePage and executes the script when the Allegiant_Home button is clicked in the extension PopUp. 
     */
    document.getElementById("CarsPage").addEventListener('click', async function () {
        console.log("in")
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {

                if (document.readyState === 'complete') {
                    var Carsport = chrome.runtime.connect({ name: "carssPagefrompopup" });
                    Carsport.postMessage({ page: document.title + "carssPage" });
                } else {
                     alert('Please let the page to load completely  before continuing')
                }
            }
        })
    })

    /*******************************Payment Page**************************************************************************** */
    /**
     * @listner navigates to the HomePage and executes the script when the Allegiant_Home button is clicked in the extension PopUp. 
     */
    document.getElementById("PaymentsPage").addEventListener('click', async function () {
        console.log("in")
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {
                if (document.readyState === 'complete') {
                    var Paymentport = chrome.runtime.connect({ name: "paymentsPagefrompopup" });
                    Paymentport.postMessage({ page: document.title + "paymentsPage" });
                } else {
                     alert('Please let the page to load completely  before continuing')
                }
            }
        })
    })
})