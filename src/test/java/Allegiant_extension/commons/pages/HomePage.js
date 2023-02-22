var HomePage = {
    CitySelect: function () {
        chrome.storage.sync.get('depCity', function (data) {
            if (data.depCity === undefined) {
                common.simulateTextEntry(document.querySelector("#select-origin"), "BLI")
                common.reactClick(common.getElement("(//div[contains(@id,'origin-option')])[1]"), "BLI")
            } else {
                common.simulateTextEntry(document.querySelector("#select-origin"), data.depCity)
                common.reactClick(common.getElement("(//div[contains(@id,'origin-option')])[1]"), data.depCity)
            }
        })
        chrome.storage.sync.get('desCity', function (data) {
            if (data.desCity === undefined) {
                common.simulateTextEntry(document.querySelector("#select-destination"), "LAS")
                common.reactClick(common.getElement("(//div[contains(@id,'destination-option')])[1]"), "LAS")
            } else {
                common.simulateTextEntry(document.querySelector("#select-destination"), data.desCity)
                common.reactClick(common.getElement("(//div[contains(@id,'destination-option')])[1]"), data.desCity)
            }
        })
    },
    ClickDepartureDateButton: function () {
        common.reactClick(common.getElement("//button[@aria-label='Open calendar for start selection']"), "Departure date button")
    },
    clickDepartureDate: function () {
        common.reactClick(document.getElementsByClassName('Day-a047d8-0 djOMQf')[1], " Departure date ")
    },
    clickDestinationDate: function () {
        common.reactClick(document.getElementsByClassName('Day-a047d8-0 djOMQf')[10], " Destination date ")
    },
    inputNumberOfPax: function () {
        chrome.storage.sync.get('paxCount', function (data) {
            if ((data.paxCount) > 1) {
                common.reactClick(common.getElement("//button[@data-hook='flight-search-travelers-expando-button']"))
                for (let index = 1; index < data.paxCount; index++) {
                    common.reactClick(common.getElement("//button[@data-hook='flight-search-adults_increment']"))
                }
            }
        })
    },
    clickSearchButton: function () {
        common.reactClick(common.getElement("//button[@data-hook='flight-search-submit']"), "Submit button")
    }
}