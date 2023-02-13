var SeatsPage = {
    VerifyDepartureTab: function () {
        let verifytabInterval = setInterval(() => {
            if ((flags.TravelerFlags.continueFlag) && (document.title === 'Seats')) {
                common.waitForElm(document.querySelector("#Tab-0"), function () {
                    if ((document.querySelector("#Tab-0").ariaSelected) === 'true') {
                        common.postMsg(" Departure seat tab is on select")
                    } else {
                        common.elementClick(document.getElementById('Tab-0'), " Departure seat tab button")
                    }
                    flags.TravelerFlags.continueFlag = false;
                    flags.SeatFlags.verifyTabFlag = true;
                    clearInterval(verifytabInterval)
                }, 300, 15000)

            }
        }, 1000);
    },
    SelectSeatsForDeparture: function (ind) {
        let depSeatInterval = setInterval(() => {

            if (flags.SeatFlags.verifyTabFlag) {
                if (common.getElement("//span[@data-hook='seat-map-spinner']") === null) {
                    common.waitForElm(common.getElement("(//span[@class='Seat-sc-1oa4g20-4 isWuWs'])[6]"), function () {
                        common.reactClick(common.getElement("(//span[@class='Seat-sc-1oa4g20-4 isWuWs'])[6]"), " seat  is clicked ")
                        chrome.storage.sync.get('paxCount', function (data) {
                            if (ind > data.paxCount - 1) {
                                flags.SeatFlags.verifyTabFlag = false;
                                flags.SeatFlags.depSeatFlag = true;
                            }

                        })
                        clearInterval(depSeatInterval)
                    }, 300, 15000)
                }
            }
        }, 1000);
    },
    clickReturnButton: function () {
        let returnButtonInterval = setInterval(() => {
            if (flags.SeatFlags.depSeatFlag) {
                if (common.getElement("//span[@data-hook='seat-map-spinner']") === null) {
                    common.waitForElm(common.getElement("//button[@data-hook='seats-page-tabs_returning']"), function () {
                        common.reactClick(common.getElement("//button[@data-hook='seats-page-tabs_returning']"), " Return seat button ")
                        flags.SeatFlags.depSeatFlag = false;
                        flags.SeatFlags.returnButtonFlag = true;
                        clearInterval(returnButtonInterval)
                    }, 300, 15000)
                }
            }
        }, 1000);
    },
    selectSeatsForReturn: function (ind) {
        let returnSeatInterval = setInterval(() => {
            if ((flags.SeatFlags.returnButtonFlag) && ((common.getElement("//button[@id='Tab-1']").ariaSelected) === 'true')) {
                if (common.getElement("//span[@data-hook='seat-map-spinner']") === null) {
                    common.reactClick(common.getElement("(//span[@class='Seat-sc-1oa4g20-4 isWuWs'])[6]"), " Return seat  is clicked ")
                    chrome.storage.sync.get('paxCount', function (data) {
                        if ((ind === data.paxCount - 1) || (data.paxCount === 1)) {
                            flags.SeatFlags.returnButtonFlag = false;
                            flags.SeatFlags.returnSeatFlag = true;
                            clearInterval(returnSeatInterval)
                        }
                    })
                }
            }
        }, 1000);
    },
    clickContinue: function () {
        let returnSeatInterval = setInterval(() => {
            if (flags.SeatFlags.returnSeatFlag) {
                common.waitForElm(common.getElement("//button[contains(@data-hook,'continue')]"), function () {
                    common.elementClick(common.getElement("//button[contains(@data-hook,'continue')]"), " Continue button ")
                    flags.SeatFlags.continueFlag = true;
                    flags.SeatFlags.returnSeatFlag = false;
                    clearInterval(returnSeatInterval)
                }, 300, 15000)

            }
        }, 1000);
    }
}