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
    getElement: function (path) {
        return document.evaluate(path, document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue;
    },
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
                        return console.error("No such elemnt: " + element)
                    loopSearch();
                }, checkFrequencyInMs);
            }
        })();
    }
}

/**
 * To set a default Pax details if the pax info was null or undefined from the Options page.
 */
chrome.storage.sync.get('paxDetails', function (data) {
    if ((data.paxDetails) === (undefined || null)) {
        let arr = [
            {
                firstName: 'Arun', lastName: 'Sachin', gender: 'male', month: 'March', phone: '6789874561', day: 1, year: 1999, mail: 'test@mail.com'
            },
            {
                firstName: 'Venkatesh', lastName: 'Baskaran', gender: 'male', month: 'March', phone: '6789874561', day: 1, year: 1999, mail: 'test@mail.com'
            }
        ]
        chrome.storage.sync.set({ 'paxDetails': arr }, function () {
            console.log(arr);
        })
    }
})

/**
 * @Function To navigate through pages.
 * @param {*} pageName 
 * @param {*} tabidnum 
 */
function navBack(pageName, tabidnum) {
    switch (pageName) {
        case "Home":
            chrome.scripting.executeScript({
                target: { tabId: tabidnum },
                func: function () {
                    window.open("https://www.allegiantair.com/", "_self")
                }
            })
            break;
        case "Flights":
            chrome.scripting.executeScript({
                target: { tabId: tabidnum },
                func: function () {
                    document.evaluate("//nav//span[contains(text(),'Flights')]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();
                }
            })
            break;
        case "Bundles":
            chrome.scripting.executeScript({
                target: { tabId: tabidnum },
                func: function () {
                    document.evaluate("//nav//span[contains(text(),'Bundles')]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();
                }
            })
            break;
        case "Travelers":
            chrome.scripting.executeScript({
                target: { tabId: tabidnum },
                func: function () {
                    document.evaluate("//nav//span[contains(text(),'Travelers')]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();
                }
            })
            break;
        case "Seats":
            chrome.scripting.executeScript({
                target: { tabId: tabidnum },
                func: function () {
                    document.evaluate("//nav//span[contains(text(),'Seats')]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();
                }
            })
            break;
        case "Bags":
            chrome.scripting.executeScript({
                target: { tabId: tabidnum },
                func: function () {
                    document.evaluate("//nav//span[contains(text(),'Bags')]", document, null, XPathResult.FIRST_ORDERED_NODE_TYPE, null).singleNodeValue.click();
                }
            })
            break;
        case "Hotels":
            chrome.scripting.executeScript({
                target: { tabId: tabidnum },
                func: function () {
                    common.reactClick(common.getElement("//span[@data-hook='flights-breadcrumb_item-hotels']"), " Hotels button ")
                }
            })
            break;
        case "Cars":
            chrome.scripting.executeScript({
                target: { tabId: tabidnum },
                func: function () {
                    common.reactClick(common.getElement("//span[@data-hook='flights-breadcrumb_item-cars']"), " Cars button ")
                }
            })
            break;
        default:
            alert("No such page")
            break;
    }
}

/**
 * @Object Has functions to inject scripts to the content page.
 */
var exeScript = {
    setFlag: function (tab, page) {
        function turnFlag(page) { common.changeFlag(page) }
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: turnFlag,
            args: [page]
        })
    },
    injectHome: function (tab) {
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { HomePage.CitySelect() }
        })
        common.hold(1500)
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { HomePage.ClickDepartureDateButton() }
        })
        common.hold(800)
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { HomePage.clickDepartureDate() }
        })
        common.hold(500)
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { HomePage.clickDestinationDate() }
        })
        common.hold(1000)
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { HomePage.inputNumberOfPax() }
        })
        common.hold(500)
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { HomePage.clickSearchButton() }
        })
    },
    injectFlight: function (tab) {
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { FlightsPage.selectFlight() }
        })
    },
    injectBundles: function (tab) {
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () {
                BundlesPage.clickPremiumButton()
                common.hold(300)
                BundlesPage.clickSearchButton()
            }
        })
    },
    injectTravelerDetails: function (tab) {
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { TravelersPage.inputPassengerDetails() }
        })
        function inputDOB(ind) {
            TravelersPage.inputDOBMonthAndDay(ind)
        }
        function selectDOB(ind) { TravelersPage.selectDOBMonthAndDay(ind) }
        chrome.storage.sync.get('paxCount', function (count) {
            for (let index = 0; index < count.paxCount; index++) {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: inputDOB,
                    args: [index]
                })
            }
            for (let index = 0; index < count.paxCount; index++) {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: selectDOB,
                    args: [index]
                })
            }
        })
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { TravelersPage.clickContinue() }
        })
    },
    injectSeats: function (tab) {
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { SeatsPage.VerifyDepartureTab() }
        })
        chrome.storage.sync.get('paxCount', function (count) {
            function depSeat(ind) { SeatsPage.SelectSeatsForDeparture(ind) }
            for (let index = 1; index <= count.paxCount; index++) {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: depSeat,
                    args: [index]
                })
            }
            chrome.scripting.executeScript({
                target: { tabId: tab },
                func: function () { SeatsPage.clickReturnButton() }
            })
            function returnSeat(ind) { SeatsPage.selectSeatsForReturn(ind) }
            for (let index = 0; index <= count.paxCount; index++) {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: returnSeat,
                    args: [index]
                })
            }
        })
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { SeatsPage.clickContinue() }
        })
    },
    injectBagsandExtras: function (tab) {
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { BagsAndExtras.checkFlag() }
        })
        chrome.storage.sync.get('addBag', function (bagData) {
            let bagCheck = null;
            if ((bagData.addBag === null) || (bagData.addBag === undefined)) {
                bagCheck = "Notchecked";

            } else {
                bagCheck = bagData.addBag;
            }
            console.log("IN bag data")
            console.log(bagCheck)
            if ((bagCheck) === 'checked') {
                console.log("IN bag if")
                chrome.storage.sync.get('paxCount', function (count) {
                    function aditionalBag(ind) { BagsAndExtras.addBagg(ind) }
                    for (let index = 0; index < count.paxCount; index++) {
                        chrome.scripting.executeScript({
                            target: { tabId: tab },
                            func: aditionalBag,
                            args: [index]
                        })
                    }
                })
                console.log("out bag if")
            } else {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: function () {
                        console.log(' Bag not added')
                    }
                })
            }
        })
        chrome.storage.sync.get('addPet', function (petData) {
            let petCheck = null;
            if ((petData.addPet === null) || (petData.addPet === undefined)) {
                petCheck = "Notchecked";
            } else {
                petCheck = petData.addPet;
            }
            console.log(petCheck)
            if (petCheck === 'checked') {
                console.log("IN pet if")
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: function () { BagsAndExtras.addToCartPet() }
                })
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: function () { BagsAndExtras.checkTravelerAndAddPet() }
                })
                console.log("Out pet if")
            } else {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: function () {
                        console.log(' Pet not added')
                    }

                })
            }
        })
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { BagsAndExtras.clickExtrasContinue() }
        })
    },
    injectHotels: function (tab) {
        chrome.storage.sync.get('addHotel', function (data) {
            let hotelInput = null;
            if ((data.addHotel === undefined) || (data.addHotel === null) || (data.addHotel === "Notchecked")) {
                hotelInput = "Notchecked";
            } else if ((data.addHotel) === 'checked') {
                hotelInput = data.addHotel;
            }
            function hotelCheckFlag(hotelInput) { Hotels.checkFlag(hotelInput) }
            chrome.scripting.executeScript({
                target: { tabId: tab },
                func: hotelCheckFlag,
                args: [hotelInput]
            })
            console.log("IN hotel injection")
            function checkHotel(check) { Hotels.checkFlag(check) }
            chrome.scripting.executeScript({
                target: { tabId: tab },
                func: checkHotel,
                args: [hotelInput]
            })
            function clickHotelCon(check) { Hotels.clickContinue(check) }
            if ((hotelInput) === 'checked') {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: function () { Hotels.FindHotelsButton() }
                })
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: function () { Hotels.slectRoomButton() }
                })
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: clickHotelCon,
                    args: [hotelInput]
                })
            } else {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: clickHotelCon,
                    args: [hotelInput]
                })
            }
        })
    },
    injectCars: function (tab) {
        chrome.storage.sync.get('addCar', function (carData) {
            let carCheck = null;
            if ((carData.addCar === undefined) || (carData.addCar === null) || (carData.addCar === "Notchecked")) {
                carCheck = "Notchecked"
            } else {
                carCheck = carData.addCar;
            }
            function CarsContinue(carCheck) { Cars.clickContinue(carCheck) }
            function carFlagCheck(carCheck) { Cars.checkFlag(carCheck) }
            chrome.scripting.executeScript({
                target: { tabId: tab },
                func: carFlagCheck,
                args: [carCheck]
            })
            if (carCheck === "checked") {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: function () { Cars.selectCar() }
                })
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: CarsContinue,
                    args: [carCheck]
                })
            } else {
                chrome.scripting.executeScript({
                    target: { tabId: tab },
                    func: CarsContinue,
                    args: [carCheck]
                })
            }
        })
    },
    injectPayment: function (tab) {
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { PaymentPage.inputFields() }
        })
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { PaymentPage.selectCountry() }
        })
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { PaymentPage.selectMonth() }
        })
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { PaymentPage.selectYear() }
        })
        chrome.scripting.executeScript({
            target: { tabId: tab },
            func: function () { PaymentPage.selectState() }
        })
    }
}

/**
 * @Listner of Message port from Allegiant_Home button in PopUp page.
 */
chrome.runtime.onConnect.addListener(function (Homeport) {
    Homeport.onMessage.addListener(function (msg) {
        if (Homeport.name === "homefrompopup") {
            if (msg.page.includes("home")) {
                console.log("in home")
                chrome.storage.session.get(["tabid"]).then((result) => {
                    console.log("Value currently is " + result.tabid);
                    var tab = result.tabid
                    if (msg.page.includes("home") && msg.page.includes('Allegiant® | Cheap')) {
                        exeScript.injectHome(tab);
                    } else {
                        navBack("Home", tab)
                    }
                })
            }
        }
    })
})

/**
 * @Listner of Message port from Flights_Page button in PopUp page.
 */
chrome.runtime.onConnect.addListener(function (Flightport) {
    Flightport.onMessage.addListener(async function (msg) {
        if (Flightport.name === "flightsfrompopup") {
            if (msg.page.includes("flight")) {
                console.log("in flight")
                chrome.storage.session.get(["tabid"]).then((result) => {
                    console.log("Value currently is " + result.tabid);
                    var tab = result.tabid
                    if (msg.page.includes("flight") && msg.page.includes('Allegiant® | Cheap')) {
                        exeScript.injectHome(tab)
                        common.hold(8000)
                        exeScript.injectFlight(tab);
                    } else if (msg.page.includes("flight") && msg.page.includes('Flights')) {
                        exeScript.injectFlight(tab);
                    } else {
                        navBack("Flights", tab)
                    }
                })
            }
        }
    })

})

/**
 * @Listner of Message port from Bundles_Page button in PopUp page.
 */
chrome.runtime.onConnect.addListener(function (Bundlesport) {
    Bundlesport.onMessage.addListener(async function (msg) {
        if (Bundlesport.name === "bundlesfrompopup") {
            if (msg.page.includes("bundles")) {
                console.log("in bundles")
                chrome.storage.session.get(["tabid"]).then((result) => {
                    console.log("Value currently is " + result.tabid);
                    var tab = result.tabid
                    if (msg.page.includes("bundles") && msg.page.includes('Allegiant® | Cheap')) {
                        exeScript.injectHome(tab)
                        common.hold(8000)
                        exeScript.injectFlight(tab);
                        exeScript.injectBundles(tab)
                    } else if (msg.page.includes("bundles") && msg.page.includes('Flights')) {
                        exeScript.injectFlight(tab);
                        exeScript.injectBundles(tab)
                    } else if (msg.page.includes("bundles") && msg.page.includes('Bundles')) {
                        exeScript.setFlag(tab, "Bundles")
                        exeScript.injectBundles(tab)
                    } else {
                        navBack("Bundles", tab)
                    }
                })
            }
        }
    })

})

/**
 * @Listner of Message port from Travelers_Page button in PopUp page.
 */
chrome.runtime.onConnect.addListener(function (Travelersport) {
    Travelersport.onMessage.addListener(async function (msg) {
        if (Travelersport.name === "travelersfrompopup") {
            if (msg.page.includes("travelers")) {
                console.log("in travelers")
                chrome.storage.session.get(["tabid"]).then((result) => {
                    console.log("Value currently is " + result.tabid);
                    var tab = result.tabid
                    if (msg.page.includes("travelers") && msg.page.includes('Allegiant® | Cheap')) {
                        exeScript.injectHome(tab)
                        common.hold(8000)
                        exeScript.injectFlight(tab)
                        exeScript.injectBundles(tab)
                        exeScript.injectTravelerDetails(tab)
                    } else if (msg.page.includes("travelers") && msg.page.includes('Flights')) {
                        exeScript.injectFlight(tab)
                        exeScript.injectBundles(tab)
                        exeScript.injectTravelerDetails(tab)
                    } else if (msg.page.includes("travelers") && msg.page.includes('Bundles')) {
                        exeScript.setFlag(tab, "Bundles")
                        exeScript.injectBundles(tab)
                        exeScript.injectTravelerDetails(tab)
                    } else if (msg.page.includes("travelers") && msg.page.includes('Travelers')) {
                        exeScript.setFlag(tab, "Travelers")
                        exeScript.injectTravelerDetails(tab)
                    } else {
                        navBack("Travelers", tab)
                    }
                })
            }
        }
    })
})

/**
 * @Listner of Message port from Seats_Page button in PopUp page.
 */
chrome.runtime.onConnect.addListener(function (Seatsport) {
    Seatsport.onMessage.addListener(async function (msg) {
        if (Seatsport.name === "seatPagefrompopup") {
            if (msg.page.includes("seatPage")) {
                console.log("in seatPage")
                chrome.storage.session.get(["tabid"]).then((result) => {
                    console.log("Value currently is " + result.tabid);
                    var tab = result.tabid
                    if (msg.page.includes("seatPage") && msg.page.includes('Allegiant® | Cheap')) {
                        exeScript.injectHome(tab)
                        common.hold(8000)
                        exeScript.injectFlight(tab)
                        exeScript.injectBundles(tab)
                        exeScript.injectTravelerDetails(tab)
                        exeScript.injectSeats(tab)
                    } else if (msg.page.includes("seatPage") && msg.page.includes('Flights')) {
                        exeScript.injectFlight(tab)
                        exeScript.injectBundles(tab)
                        exeScript.injectTravelerDetails(tab)
                        exeScript.injectSeats(tab)
                    } else if (msg.page.includes("seatPage") && msg.page.includes('Bundles')) {
                        exeScript.setFlag(tab, "Bundles")
                        exeScript.injectBundles(tab)
                        exeScript.injectTravelerDetails(tab)
                        exeScript.injectSeats(tab)
                    } else if (msg.page.includes("seatPage") && msg.page.includes('Travelers')) {
                        exeScript.setFlag(tab, "Travelers")
                        exeScript.injectTravelerDetails(tab)
                        exeScript.injectSeats(tab)
                    } else if (msg.page.includes("seatPage") && msg.page.includes('Seats')) {
                        exeScript.setFlag(tab, "Seats")
                        exeScript.injectSeats(tab)
                    } else {
                        navBack("Seats", tab)
                    }
                })
            }
        }
    })
})

/**
 * @Listner of Message port from Bags_Page button in PopUp page.
 */
chrome.runtime.onConnect.addListener(function (Bagsport) {
    Bagsport.onMessage.addListener(async function (msg) {
        if (Bagsport.name === "BagPagefrompopup") {
            if (msg.page.includes("BagPage")) {
                console.log("in BagPage")
                chrome.storage.session.get(["tabid"]).then((result) => {
                    console.log("Value currently is " + result.tabid);
                    var tab = result.tabid
                    if (msg.page.includes("BagPage") && msg.page.includes('Allegiant® | Cheap')) {
                        exeScript.injectHome(tab)
                        common.hold(8000)
                        exeScript.injectFlight(tab)
                        exeScript.injectBundles(tab)
                        exeScript.injectTravelerDetails(tab)
                        exeScript.injectSeats(tab)
                        exeScript.injectBagsandExtras(tab)
                    } else if (msg.page.includes("BagPage") && msg.page.includes('Flights')) {
                        exeScript.injectFlight(tab)
                        exeScript.injectBundles(tab)
                        exeScript.injectTravelerDetails(tab)
                        exeScript.injectSeats(tab)
                        exeScript.injectBagsandExtras(tab)
                    } else if (msg.page.includes("BagPage") && msg.page.includes('Bundles')) {
                        exeScript.setFlag(tab, "Bundles")
                        exeScript.injectBundles(tab)
                        exeScript.injectTravelerDetails(tab)
                        exeScript.injectSeats(tab)
                        exeScript.injectBagsandExtras(tab)
                    } else if (msg.page.includes("BagPage") && msg.page.includes('Travelers')) {
                        exeScript.setFlag(tab, "Travelers")
                        exeScript.injectTravelerDetails(tab)
                        exeScript.injectSeats(tab)
                        exeScript.injectBagsandExtras(tab)
                    } else if (msg.page.includes("BagPage") && msg.page.includes('Seats')) {
                        exeScript.setFlag(tab, "Seats")
                        exeScript.injectSeats(tab)
                        exeScript.injectBagsandExtras(tab)
                    } else if (msg.page.includes("BagPage") && msg.page.includes('Bags and Extras')) {
                        exeScript.setFlag(tab, "Bags and Extras")
                        exeScript.injectBagsandExtras(tab)
                    } else {
                        navBack("Bags", tab)
                    }
                })
            }
        }
    })
})

/**
 * @Listner of Message port from Hotels_Page button in PopUp page.
 */
chrome.runtime.onConnect.addListener(function (Hotelsport) {
    Hotelsport.onMessage.addListener(function (msg) {
        if (Hotelsport.name === "hotelsPagefrompopup") {
            chrome.storage.session.get(["tabid"]).then((result) => {
                console.log("Value currently is " + result.tabid);
                console.log("IN HotelsPage" + msg.page)
                var tab = result.tabid
                if (msg.page.includes("hotelsPage") && msg.page.includes('Allegiant® | Cheap')) {
                    exeScript.injectHome(tab)
                    common.hold(6000)
                    exeScript.injectFlight(tab)
                    exeScript.injectBundles(tab)
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                } else if (msg.page.includes("hotelsPage") && msg.page.includes('Flights')) {
                    exeScript.injectFlight(tab)
                    exeScript.injectBundles(tab)
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                } else if (msg.page.includes("hotelsPage") && msg.page.includes('Bundles')) {
                    exeScript.setFlag(tab, "Bundles")
                    exeScript.injectBundles(tab)
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                } else if (msg.page.includes("hotelsPage") && msg.page.includes('Travelers')) {
                    exeScript.setFlag(tab, "Travelers")
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                } else if (msg.page.includes("hotelsPage") && msg.page.includes('Seats')) {
                    exeScript.setFlag(tab, "Seats")
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                } else if (msg.page.includes("hotelsPage") && msg.page.includes('Bags and Extras')) {
                    exeScript.setFlag(tab, "Bags and Extras")
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                } else if (msg.page.includes("hotelsPage") && msg.page.includes('Hotels')) {
                    exeScript.setFlag(tab, "Hotels")
                    exeScript.injectHotels(tab)
                } else {
                    if (msg.page.includes("hotelsPage")) {
                        navBack("Hotels", tab)
                    }
                }
            })
        }
    })
})

/**
 * @Listner of Message port from Cars_Page button in PopUp page.
 */
chrome.runtime.onConnect.addListener(function (Carsport) {
    Carsport.onMessage.addListener(function (msg) {
        if (Carsport.name === "carssPagefrompopup") {
            chrome.storage.session.get(["tabid"]).then((result) => {
                console.log("Value currently is " + result.tabid);
                console.log("IN CarsPage" + msg.page)
                var tab = result.tabid
                if (msg.page.includes("carssPage") && msg.page.includes('Allegiant® | Cheap')) {
                    exeScript.injectHome(tab)
                    common.hold(6000)
                    exeScript.injectFlight(tab)
                    exeScript.injectBundles(tab)
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                } else if (msg.page.includes("carssPage") && msg.page.includes('Flights')) {
                    exeScript.injectFlight(tab)
                    exeScript.injectBundles(tab)
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                } else if (msg.page.includes("carssPage") && msg.page.includes('Bundles')) {
                    exeScript.setFlag(tab, "Bundles")
                    exeScript.injectBundles(tab)
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                } else if (msg.page.includes("carssPage") && msg.page.includes('Travelers')) {
                    exeScript.setFlag(tab, "Travelers")
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                } else if (msg.page.includes("carssPage") && msg.page.includes('Seats')) {
                    exeScript.setFlag(tab, "Seats")
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                } else if (msg.page.includes("carssPage") && msg.page.includes('Bags and Extras')) {
                    exeScript.setFlag(tab, "Bags and Extras")
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                } else if (msg.page.includes("carssPage") && msg.page.includes('Hotels')) {
                    exeScript.setFlag(tab, "Hotels")
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                } else if (msg.page.includes("carssPage") && msg.page.includes('Car')) {
                    exeScript.injectCars(tab)
                } else {
                    if (msg.page.includes("carssPage")) {
                        navBack("Cars", tab)
                    }
                }
            })
        }
    })
})

/**
 * @Listner of Message port from Payment_Page button in PopUp page.
 */
chrome.runtime.onConnect.addListener(function (Paymentport) {
    Paymentport.onMessage.addListener(function (msg) {
        if (Paymentport.name === "paymentsPagefrompopup") {
            chrome.storage.session.get(["tabid"]).then((result) => {
                console.log("Value currently is " + result.tabid);
                console.log("IN PaymentsPage" + msg.page)
                var tab = result.tabid
                if (msg.page.includes("paymentsPage") && msg.page.includes('Allegiant® | Cheap')) {
                    exeScript.injectHome(tab)
                    common.hold(6000)
                    exeScript.injectFlight(tab)
                    exeScript.injectBundles(tab)
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                    exeScript.injectPayment(tab)
                } else if (msg.page.includes("paymentsPage") && msg.page.includes('Flights')) {
                    exeScript.injectFlight(tab)
                    exeScript.injectBundles(tab)
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                    exeScript.injectPayment(tab)
                } else if (msg.page.includes("paymentsPage") && msg.page.includes('Bundles')) {
                    exeScript.setFlag(tab, "Bundles")
                    exeScript.injectBundles(tab)
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                    exeScript.injectPayment(tab)
                } else if (msg.page.includes("paymentsPage") && msg.page.includes('Travelers')) {
                    exeScript.setFlag(tab, "Travelers")
                    exeScript.injectTravelerDetails(tab)
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                    exeScript.injectPayment(tab)
                } else if (msg.page.includes("paymentsPage") && msg.page.includes('Seats')) {
                    exeScript.setFlag(tab, "Seats")
                    exeScript.injectSeats(tab)
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                    exeScript.injectPayment(tab)
                } else if (msg.page.includes("paymentsPage") && msg.page.includes('Bags and Extras')) {
                    exeScript.setFlag(tab, "Bags and Extras")
                    exeScript.injectBagsandExtras(tab)
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                    exeScript.injectPayment(tab)
                } else if (msg.page.includes("paymentsPage") && msg.page.includes('Hotels')) {
                    exeScript.setFlag(tab, "Hotels")
                    exeScript.injectHotels(tab)
                    exeScript.injectCars(tab)
                    exeScript.injectPayment(tab)
                } else if (msg.page.includes("paymentsPage") && msg.page.includes('Car')) {
                    exeScript.setFlag(tab, "Cars")
                    exeScript.injectCars(tab)
                    exeScript.injectPayment(tab)
                } else if (msg.page.includes("paymentsPage") && msg.page.includes('Payment')) {
                    exeScript.injectPayment(tab)
                }
            })
        }
    })
})