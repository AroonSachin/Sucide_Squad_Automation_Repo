var TravelersPage = {
    inputPassengerDetails: function () {
        let paxDetailInterval = setInterval(() => {

            if (flags.BundlesFlag.continueFlag && (document.title === "Travelers")) {
                common.waitForElm(common.getElement("//input[@id='adults.0.first-name']"), function () {
                    console.log("in passenger details script")
                    chrome.storage.sync.get('paxDetails', function (data) {
                        console.log("in get data")
                        var paxInfo = data.paxDetails;
                        chrome.storage.sync.get('paxCount', function (count) {
                            console.log("in get count")
                            //For loop for first name.
                            for (let index = 0; index < count.paxCount; index++) {
                                common.simulateTextEntry(common.getElement("//input[@id='adults." + index + ".first-name']"), paxInfo[index].firstName)
                            }

                            //For loop for last name.
                            for (let index = 0; index < count.paxCount; index++) {
                                common.simulateTextEntry(common.getElement("//input[@id='adults." + index + ".last-name']"), paxInfo[index].lastName)
                            }

                            //For loop for gender.
                            for (let index = 0; index < count.paxCount; index++) {
                                if ((paxInfo.gender) === 'male') {
                                    common.reactClick(common.getElement("//label[@data-hook='travelers-form_adults_" + index + "_gender_MALE']"), "Male radio button ")
                                } else {
                                    common.reactClick(common.getElement("//label[@data-hook='travelers-form_adults_" + index + "_gender_FEMALE']"), "FEMale radio button ")
                                }
                            }

                            //For loop for year.
                            for (let index = 0; index < count.paxCount; index++) {
                                common.simulateTextEntry(common.getElement("//input[@id='adults." + index + ".dob-year']"), paxInfo[index].year)
                            }

                            //For loop for phone.
                            for (let index = 0; index < count.paxCount; index++) {
                                common.simulateTextEntry(common.getElement("//input[@id='adults." + index + ".primary-phone-number']"), paxInfo[index].phone)
                            }

                            //For loop for email.
                            for (let index = 0; index < count.paxCount; index++) {
                                common.simulateTextEntry(common.getElement("//input[@id='adults." + index + ".email']"), paxInfo[index].mail)
                            }
                            flags.BundlesFlag.continueFlag = false;
                            flags.TravelerFlags.paxDetailsFlag = true;
                        })
                    })
                    clearInterval(paxDetailInterval)
                }, 1000, 15000)
            }

        }, 1000);

    },
    inputDOBMonthAndDay: function (ind) {
        let monthInterval = setInterval(() => {
            if (flags.TravelerFlags.paxDetailsFlag) {
                console.log("Inputing month and day")
                chrome.storage.sync.get('paxDetails', function (paxdata) {
                    console.log(paxdata.paxDetails[ind].month)
                    common.hold(1000)
                    common.simulateTextEntry(document.querySelector("#adults\\." + ind + "\\.dob-month"), "May")
                    common.reactClick(common.getElement("//div[@data-hook='travelers-form_adults_" + ind + "_dob-day']"), "Month dropdown ")
                    common.simulateTextEntry(common.getElement("//input[@id='adults." + ind + ".dob-day']"), paxdata.paxDetails[0].day)
                    chrome.storage.sync.get('paxCount', function (data) {
                        console.log(ind + "and " + data.paxCount)
                        if (ind === data.paxCount - 1) {
                            flags.TravelerFlags.paxDetailsFlag = false;
                            flags.TravelerFlags.inputMonthFlag = true;
                        }
                    })
                })
                clearInterval(monthInterval)
            }
        }, 1000);

    },
    selectDOBMonthAndDay: function (ind) {
        let selectmonthInterval = setInterval(() => {
            if (flags.TravelerFlags.inputMonthFlag) {
                console.log("Select month and day")
                common.hold(1000)
                common.reactClick(common.getElement("//div[contains(@id,'react-select-adults." + ind + ".dob-month-option')]"), " Month Option for pax " + (ind + 1) + "  ")
                common.reactClick(common.getElement("(//div[contains(@id,'react-select-adults." + ind + ".dob-day-option')])[1]"), " Day Option for pax " + (ind + 1) + "  ")
                chrome.storage.sync.get('paxCount', function (data) {
                    if (ind === data.paxCount - 1) {
                        flags.TravelerFlags.inputMonthFlag = false,
                            flags.TravelerFlags.finalFlag = true;
                    }
                })
                clearInterval(selectmonthInterval)
            }
        }, 1000);
    },
    clickContinue: function () {
        let travelerContinueInterval = setInterval(() => {
            if (flags.TravelerFlags.finalFlag) {
                common.waitForElm(common.getElement("//button[contains(@data-hook,'continue')]"), function () {
                    common.reactClick(common.getElement("//button[contains(@data-hook,'continue')]"), " Continue button ")
                    flags.TravelerFlags.finalFlag = false;
                    flags.TravelerFlags.continueFlag = true;
                    clearInterval(travelerContinueInterval)
                }, 300, 15000)

            }
        }, 1000);
    }
}