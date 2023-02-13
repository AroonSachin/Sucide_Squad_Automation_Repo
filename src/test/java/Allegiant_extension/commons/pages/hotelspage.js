var Hotels= {
    FindHotelsButton: function () {
        let findHotelInterval = setInterval(() => {
            if ((flags.bagsAndExtrasFlags.continueFlag) && (document.title === "Hotels")) {
                common.waitForElm(common.getElement("(//a[@class='HotelCard__HotelCardButton-isxhr6-2 bKaulB'])[1]"), function () {
                    common.reactClick(common.getElement("(//a[@class='HotelCard__HotelCardButton-isxhr6-2 bKaulB'])[1]"), "Find Hotel button ")
                    flags.bagsAndExtrasFlags.continueFlag = false;
                    flags.HotelsFlags.findHotelFlag = true;
                    clearInterval(findHotelInterval)
                }, 300, 15000)
            }
        }, 1000);
    },
    slectRoomButton: function () {
        let selectRoomInterval = setInterval(() => {
            if (flags.HotelsFlags.findHotelFlag) {
                common.waitForElm(common.getElement("//button[@data-hook='room-pod_hotel-book-button']"), function () {
                    common.reactClick(common.getElement("//button[@data-hook='room-pod_hotel-book-button']"), "Select room button ")
                    flags.HotelsFlags.findHotelFlag = false;
                    flags.HotelsFlags.selectRoomFlag = true;
                    clearInterval(selectRoomInterval)
                }, 300, 15000)
            }
        }, 1000);
    },
    clickContinue: function (check) {
        let hotelcontinueInterval = setInterval(() => {
            if (flags.HotelsFlags.selectRoomFlag) {
                if (check === "checked") {
                    common.waitForElm(common.getElement("//button[@data-hook='hotel-details-page_continue']"), function () {
                        common.reactClick(common.getElement("//button[@data-hook='hotel-details-page_continue']"), "Continue room button ")
                        flags.HotelsFlags.selectRoomFlag = false;
                        flags.HotelsFlags.ContinueFlag = true;
                        clearInterval(hotelcontinueInterval)
                    }, 300, 15000)
                } else {
                    common.waitForElm(common.getElement("//button[@data-hook='hotels-page_continue']"), function () {
                        common.reactClick(common.getElement("//button[@data-hook='hotels-page_continue']"), "Continue room button ")
                        flags.HotelsFlags.selectRoomFlag = false;
                        flags.HotelsFlags.ContinueFlag = true;
                        clearInterval(hotelcontinueInterval)
                    }, 300, 15000)
                }
            }
        }, 1000);
    },
    checkFlag: function (check) {
        let hotelFlagInterval = setInterval(() => {
            if (flags.bagsAndExtrasFlags.continueFlag && (document.title === "Hotels") && (document.readyState === 'complete')) {
                common.waitForElm(common.getElement("(//a[@class='HotelCard__HotelCardButton-isxhr6-2 bKaulB'])[1]"), function () {
                    if (check === "Notchecked") {
                        flags.bagsAndExtrasFlags.continueFlag = false;
                        flags.HotelsFlags.selectRoomFlag = true;
                        clearInterval(hotelFlagInterval)
                    } else {
                        clearInterval(hotelFlagInterval)
                    }
                }, 1000, 15000)
            }
        }, 1000);
    }
}