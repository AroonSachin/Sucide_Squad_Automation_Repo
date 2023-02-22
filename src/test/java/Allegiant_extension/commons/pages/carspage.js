var Cars= {
    checkFlag: function (carCheck) {
        let carsCheckFlagInterval = setInterval(() => {
            console.log("Waiting checkFlag")
            if (flags.HotelsFlags.ContinueFlag) {
                console.log("In check flag")
                if (carCheck === "checked") {
                    flags.carsPageFlags.checkedFlag = true;
                    flags.HotelsFlags.ContinueFlag = false;
                    clearInterval(carsCheckFlagInterval)
                } else {
                    flags.HotelsFlags.ContinueFlag = false;
                    flags.carsPageFlags.carSelectionFlag = true;
                    clearInterval(carsCheckFlagInterval)
                }
            }
        }, 1000);
    },
    selectCar: function () {
        let carSelectionInterval = setInterval(() => {
            if (flags.carsPageFlags.checkedFlag) {
                common.waitForElm(common.getElement("(//button[@class='Button__StyledButton-sc-1ececxa-1 eznEzY CarVendorPrices__PriceSelectionButton-ayz81e-3 kZTAAf'])[1]"), function () {
                    common.reactClick(common.getElement("(//button[@class='Button__StyledButton-sc-1ececxa-1 eznEzY CarVendorPrices__PriceSelectionButton-ayz81e-3 kZTAAf'])[1]"), "Car price button")
                    flags.carsPageFlags.checkedFlag = false;
                    flags.carsPageFlags.carSelectionFlag = true;
                    clearInterval(carSelectionInterval);
                })
            }
        }, 1000);
    },
    clickContinue: function (check) {
        let carContinueInterval = setInterval(() => {
            if (flags.carsPageFlags.carSelectionFlag) {
                if (check === "checked") {
                    common.waitForElm(common.getElement("//button[@class='Button__StyledButton-sc-1ececxa-1 ijtqnd CarVendorPrices__PriceSelectionButton-ayz81e-3 kZTAAf']"), function () {
                        common.reactClick(common.getElement("//button[@data-hook='cars-page_continue']"), "Car continue button ")
                        flags.carsPageFlags.continueFlag = true;
                        flags.carsPageFlags.carSelectionFlag = false;
                        clearInterval(carContinueInterval)
                    }, 300, 15000)
                } else {
                    common.waitForElm(common.getElement("//button[@data-hook='cars-page_continue']"), function () {
                        common.reactClick(common.getElement("//button[@data-hook='cars-page_continue']"), "Car continue button ")
                        flags.carsPageFlags.continueFlag = true;
                        flags.carsPageFlags.carSelectionFlag = false;
                        clearInterval(carContinueInterval)
                    }, 300, 15000)
                }
            }
        }, 1000);
    }
}