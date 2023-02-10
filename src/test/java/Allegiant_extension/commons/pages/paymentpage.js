var PaymentPage= {
    inputFields: function () {
        let paymentInputInterval = setInterval(() => {
            if (flags.carsPageFlags.continueFlag && document.title==='Payment') {
                common.waitForElm(common.getElement("//input[@id='card-number']"), function () {
                    if (common.getElement("//button[@data-hook='payment-page_ice-popup_close']") != null) {
                        common.reactClick(common.getElement("//button[@data-hook='payment-page_ice-popup_close']"), " Ad Close ")
                    }
                    chrome.storage.sync.get('cardNum', function (cardData) {
                        common.simulateTextEntry(document.forms[3].elements['card-number'], cardData.cardNum)
                    })

                    chrome.storage.sync.get('cardCVV', function (cardcvvData) {
                        common.simulateTextEntry(document.forms[3].elements['card-cvv'], cardcvvData.cardCVV)
                    })

                    chrome.storage.sync.get('BillstreetAdd', function (billStreetdata) {
                        common.simulateTextEntry(document.forms[3].elements['address-line-1'], billStreetdata.BillstreetAdd)
                    })

                    chrome.storage.sync.get('Billstreet2', function (BillStreet2data) {
                        common.simulateTextEntry(document.forms[3].elements['address-line-2'], BillStreet2data.Billstreet2)
                    })

                    chrome.storage.sync.get('BillCity', function (BillcityData) {
                        common.simulateTextEntry(document.forms[3].elements['city'], BillcityData.BillCity)
                    })

                    chrome.storage.sync.get('BillzipCode', function (billZipData) {
                        common.simulateTextEntry(document.forms[3].elements['zip-code'], billZipData.BillzipCode)
                    })

                    chrome.storage.sync.get('Billphone', function (BillphoneData) {
                        common.simulateTextEntry(document.forms[3].elements['phone-number'], BillphoneData.Billphone)
                    })

                    chrome.storage.sync.get('BillMail', function (BillmailData) {
                        common.simulateTextEntry(document.forms[3].elements['email-address'], BillmailData.BillMail)
                        common.reactClick(document.forms[3].getElementsByClassName("Checkbox__CheckboxWrapper-gyke29-0 iSNTkk")[0], "Recieve mail check box ")
                        common.reactClick(document.forms[3].getElementsByClassName("Checkbox__CheckboxWrapper-gyke29-0 iSNTkk")[2], " T & C check box ")
                        common.reactClick(document.forms[3].getElementsByClassName(" css-1hwfws3")[2], " Country ")
                        flags.carsPageFlags.continueFlag = false;
                        flags.PaymentFlags.countryFlag = true;
                        clearInterval(paymentInputInterval);
                    })
                }, 300, 15000);
            }
        }, 3000)
    },
    selectCountry: function () {
        let countrySelectInterval = setInterval(() => {
            if (flags.PaymentFlags.countryFlag) {
                chrome.storage.sync.get('Billcountry', function (countryData) {
                    common.waitForElm(common.getElement("//div[contains(@data-hook,'payment-page_country-field')]//div[contains(text(),'India')]"), function () {
                        common.reactClick(common.getElement("//div[contains(@data-hook,'payment-page_country-field')]//div[contains(text(),'" + countryData.Billcountry + "')]"), "Country Option ")
                        common.reactClick(document.forms[3].getElementsByClassName(" css-1hwfws3")[0], "Month dropdown ")
                        flags.PaymentFlags.countryFlag = false;
                        flags.PaymentFlags.monthFlag = true;
                        clearInterval(countrySelectInterval)
                    }, 300, 15000)
                })
            }
        }, 1000);
    },
    selectMonth: function () {
        let mmonthSelectInterval = setInterval(() => {
            if (flags.PaymentFlags.monthFlag) {
                chrome.storage.sync.get('expMonth', function (expMonthdata) {
                    common.waitForElm(common.getElement("//div[contains(text(),'" + expMonthdata.expMonth + "')]"), function () {
                        common.reactClick(common.getElement("//div[contains(text(),'" + expMonthdata.expMonth + "')]"), expMonthdata.expMonth + " option is selected")
                        common.reactClick(document.forms[3].getElementsByClassName(" css-1hwfws3")[1], "Year dropdown ")
                        flags.PaymentFlags.yearFlag = true;
                        flags.PaymentFlags.monthFlag = false;
                        clearInterval(mmonthSelectInterval)
                    }, 300, 15000)
                })
            }
        }, 1000);
    },
    selectYear: function () {
        let yearSelectInterval = setInterval(() => {
            if (flags.PaymentFlags.yearFlag) {
                chrome.storage.sync.get('expYear', function (expYeardata) {
                    common.waitForElm(common.getElement("//div[contains(text(),'" + expYeardata.expYear + "')]"), function () {
                        common.reactClick(common.getElement("//div[contains(text(),'" + expYeardata.expYear + "')]"), expYeardata.expYear + " option is selected")
                        common.reactClick(document.forms[3].getElementsByClassName(" css-1hwfws3")[3], " State ")
                        flags.PaymentFlags.stateFlag = true;
                        flags.PaymentFlags.yearFlag = false;
                        clearInterval(yearSelectInterval)
                    })

                })
            }
        }, 1000);
    },
    selectState: function () {
        let stateSelectInterval = setInterval(() => {
            if (flags.PaymentFlags.stateFlag) {
                common.waitForElm(common.getElement("(//div[contains(@id,'react-select-state-option')])[1]"), function () {
                    common.reactClick(common.getElement("(//div[contains(@id,'react-select-state-option')])[1]"), "State Option ")
                    flags.PaymentFlags.stateFlag = false;
                    clearInterval(stateSelectInterval)
                })
            }
        }, 1000);
    }
}