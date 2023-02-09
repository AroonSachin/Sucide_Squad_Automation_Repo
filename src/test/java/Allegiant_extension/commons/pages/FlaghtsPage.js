var FlightsPage= {
    selectFlight: function () {
        common.waitForElm(document.querySelector("#main > div.Box-s8oj9r-0.bKncCT > div.Box-s8oj9r-0.dZSFlD > div > button"), function () {
            common.reactClick(document.querySelector("#main > div.Box-s8oj9r-0.bKncCT > div.Box-s8oj9r-0.dZSFlD > div > button"), " Continue button ")
            flags.flightsFlags.finalFlag = true;
        }, 300, 15000)
    }
}