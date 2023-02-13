var BagsAndExtras= {
    checkFlag: function () {
        let bagAndExtrasCheckFlagInterval = setInterval(() => {
            if ((flags.SeatFlags.continueFlag === true) && (document.title === "Bags and Extras") && (document.readyState === 'complete')) {
                chrome.storage.sync.get('addBag', function (bagData) {
                    chrome.storage.sync.get('addPet', function (petData) {
                        if ((bagData.addBag === "Notchecked") && (petData.addPet === "Notchecked")) {
                            flags.SeatFlags.continueFlag = false;
                            flags.bagsAndExtrasFlags.selectTravelerFlag = true;
                            clearInterval(bagAndExtrasCheckFlagInterval)
                        } else if ((bagData.addBag === "Notchecked") && (petData.addPet === "checked")) {
                            flags.SeatFlags.continueFlag = false;
                            flags.bagsAndExtrasFlags.addBagFlag = true;
                            clearInterval(bagAndExtrasCheckFlagInterval)
                        } else if ((bagData.addBag === "checked") && (petData.addPet === "Notchecked")) {
                            clearInterval(bagAndExtrasCheckFlagInterval)
                        } else if ((bagData.addBag === "checked") && (petData.addPet === "checked")) {
                            clearInterval(bagAndExtrasCheckFlagInterval)
                        }
                    })
                })
            }
        }, 10000);
    },
    addBagg: function (ind) {
        let addBagInterval = setInterval(() => {
            if ((flags.SeatFlags.continueFlag) && (document.title === 'Bags and Extras')) {
                common.waitForElm(common.getElement("//input[@id='flights[0][0].checkIn']"), function () {
                    if (common.getElement("//input[@id='flights[0][" + ind + "].checkIn']").value === '1') {
                        common.reactClick(common.getElement("(//button[@class='QuantitySelector__Button-gxhe5k-0 QuantitySelector__IncrementButton-gxhe5k-2 iHVCCK'])[" + (ind + 1) + "]"), "Bag added for passenger:" + (ind + 1))
                    } else {
                        console.log("Baggage points greater than 1")
                    }
                    chrome.storage.sync.get('paxCount', function (data) {
                        if (ind === data.paxCount - 1) {
                            chrome.storage.sync.get('addPet', function (petData) {
                                if (petData.addPet === "checked") {
                                    flags.SeatFlags.continueFlag = false;
                                    flags.bagsAndExtrasFlags.addBagFlag = true;
                                } else if (petData.addPet === "Notchecked") {
                                    flags.SeatFlags.continueFlag = false;
                                    flags.bagsAndExtrasFlags.selectTravelerFlag = true;
                                }
                            })
                        }
                    })
                    clearInterval(addBagInterval)
                }, 500, 15000)
            }
        }, 1000);
    },

    addToCartPet: function () {
        let addPetcartInterval = setInterval(() => {
            if (flags.bagsAndExtrasFlags.addBagFlag) {
                common.waitForElm(common.getElement("//input[@id='flights[0][0].checkIn']"), function () {
                    if (common.getElement("//button[@data-hook='pet-in-cabin-card_add-to-cart']") != null) {
                        common.reactClick(common.getElement("//button[@data-hook='pet-in-cabin-card_add-to-cart']"), " Add to cart for pet ")
                        flags.bagsAndExtrasFlags.addBagFlag = false;
                        flags.bagsAndExtrasFlags.addToCartFlag = true,
                            clearInterval(addPetcartInterval)
                    } else {
                        flags.bagsAndExtrasFlags.selectTravelerFlag = true;
                        clearInterval(addPetcartInterval)
                    }
                }, 500, 15000)
            }
        }, 1000);
    },
    checkTravelerAndAddPet: function () {
        let checkandAddPet = setInterval(() => {
            if (flags.bagsAndExtrasFlags.addToCartFlag) {
                if (common.getElement("//button[@data-hook='pet-in-cabin-card_add-to-cart']") != null) {
                    common.reactClick(common.getElement("(//div[@data-hook='extras-popup-flight-leg_departing']//label)[1]//div[@class='Checkbox__CheckboxWrapper-gyke29-0 kJEboX']"), " Traveler pet checkbox ")
                    common.reactClick(common.getElement("//button[@data-hook='pet-in-cabin-modal_add-to-cart']"), " Add to cart button in frame for pet ")
                    flags.bagsAndExtrasFlags.addToCartFlag = false;
                    flags.bagsAndExtrasFlags.selectTravelerFlag = true;
                    clearInterval(checkandAddPet)
                }
            }
        }, 1000);
    },
    clickExtrasContinue: function () {
        let extrasContinueInterval = setInterval(() => {
            if ((flags.bagsAndExtrasFlags.selectTravelerFlag) && (document.title === 'Bags and Extras')) {
                common.waitForElm(common.getElement("(//div[@class='Box-s8oj9r-0 hEucNx'])[2]//button"), function () {
                    common.reactClick(common.getElement("(//div[@class='Box-s8oj9r-0 hEucNx'])[2]//button"), " continue button ")
                    flags.bagsAndExtrasFlags.selectTravelerFlag = false;
                    flags.bagsAndExtrasFlags.continueFlag = true;
                    clearInterval(extrasContinueInterval)
                }, 500, 15000)
            }
        }, 1000);
    }
}