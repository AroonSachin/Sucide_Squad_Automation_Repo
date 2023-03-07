$(function () {
    console.log("inside function")
    $('#Submit').click(function () {
        let depCity = $('#DepartureCity').val();
        let desCity = $('#DestinationCity').val();
        let paxCount = $('#PassengersCount').val();
        let cardNumber = $('#CardNumber').val();
        let CardCVV = $('#CardCVV').val();
        let expMonth = $('#Cardmonth').val();
        let expDay = $('#Cardday').val();
        let expYear = $('#Cardyear').val();
        if (depCity) {
            chrome.storage.sync.set({ 'depCity': depCity }, function () {
            })
        }
        if (desCity) {
            chrome.storage.sync.set({ 'desCity': desCity }, function () {
            })
        }
        if (paxCount) {
            chrome.storage.sync.set({ 'paxCount': paxCount }, function () {
            })
        }

        let paxArr = Array.apply(null, Array(8))
        for (let pax = 0; pax < paxCount; pax++) {
            paxArr[pax] = {
                firstName: faker.name.firstName(), lastName: faker.name.lastName(), gender: faker.random.arrayElement(['male', 'female']), month: faker.date.month(), phone: faker.phone.phoneNumber('687-###-####'), day: faker.random.number({ 'min': 1, 'max': 28 }), year: 1999 - pax, mail: faker.internet.email()
            }
        }
        chrome.storage.sync.set({ 'paxDetails': paxArr }, function () {
            console.log(paxArr);
        })
        let date = new Date();
        date.setDate(date.getDate() + 5);
        let dateArr = date.toString().split(' ')
        chrome.storage.sync.set({ 'dateArr': dateArr }, function () {
            console.log(dateArr);
        })
        console.log(document.getElementById("Bag").checked)
        if (document.getElementById("Bag").checked) {
            chrome.storage.sync.set({ 'addBag':'checked'  }, function () { })
        } else if (document.getElementById("Bag").checked=== false) { chrome.storage.sync.set({ 'addBag': "Notchecked" }, function () { })}
        if (document.getElementById("Pet").checked === true) {
            chrome.storage.sync.set({ 'addPet': "checked" }, function () { })
        } else if (document.getElementById("Pet").checked === false) { chrome.storage.sync.set({ 'addPet': "Notchecked" }, function () { })}

        chrome.storage.sync.get('addBag',function(data){
            if(data.addBag===null || data.addBag===undefined){
                chrome.storage.sync.set({ 'addBag':'Notchecked'  }, function () { })
            }
        })
        chrome.storage.sync.get('addPet',function(data){
            if(data.addPet===null || data.addPet===undefined){
                chrome.storage.sync.set({ 'addPet':'Notchecked'  }, function () { })
            }
        })
        if (document.getElementById("Hotel").checked) {
            chrome.storage.sync.set({ 'addHotel':'checked'  }, function () { })
        } else if (document.getElementById("Bag").checked=== false) { chrome.storage.sync.set({ 'addHotel': "Notchecked" }, function () { })}

        if (document.getElementById("Car").checked) {
            chrome.storage.sync.set({ 'addCar':'checked'  }, function () { })
        } else if (document.getElementById("Car").checked=== false) { chrome.storage.sync.set({ 'addBag': "Notchecked" }, function () { })}

        if(cardNumber===null || cardNumber === undefined){
            chrome.storage.sync.set({'cardNum':"9874-7894-8478-5489"},function(){})
        }else{chrome.storage.sync.set({'cardNum':cardNumber},function(){})}

        if((CardCVV === null)|| (CardCVV === undefined)){
            chrome.storage.sync.set({'CardCVV':faker.random.number({ 'min': 200, 'max': 900 })},function(){})
        }else{chrome.storage.sync.set({'CardCVV':CardCVV},function(){ console.log("CVV-"+CardCVV)})}
        if(expMonth===null|| expMonth === undefined){
            chrome.storage.sync.set({'expMonth':"March"},function(){})
        }else{chrome.storage.sync.set({'expMonth':expMonth},function(){})}

        if(expDay===null|| expDay === undefined){
            chrome.storage.sync.set({'expDay': faker.random.number({ 'min': 1, 'max': 28 })},function(){})
        }else{chrome.storage.sync.set({'expDay':expDay},function(){})}

        let yearDate = new Date();
        yearDate.setDate(yearDate.getDate() + 2000);
        let yearArr = yearDate.toString().split(' ')
        if(expYear===null || expYear === undefined){
            chrome.storage.sync.set({'expYear': yearArr[3]},function(){})
        }else{chrome.storage.sync.set({'expYear':expYear},function(){})}

        chrome.storage.sync.set({'Billcountry': faker.address.country() },function(){})

        chrome.storage.sync.set({'BillstreetAdd':faker.address.streetAddress()})

        chrome.storage.sync.set({'Billstreet2':faker.address.secondaryAddress()},function(){ })

        chrome.storage.sync.set({'BillCity':faker.address.city()},function(){ })

        chrome.storage.sync.set({'BillzipCode':faker.address.zipCode()},function(){})

        chrome.storage.sync.set({'Billphone':faker.phone.phoneNumber('687-###-####')},function(){})

        chrome.storage.sync.set({'BillMail':faker.internet.email()},function(){})

        let newURL = "https://www.allegiantair.com/";
        chrome.tabs.create({ url: newURL });
        close();
    })
    $('#reset').click(function () {
        let yearDate = new Date();
        yearDate.setDate(yearDate.getDate() + 2000);
        let yearArr = yearDate.toString().split(' ')
        $('#DepartureCity').val("BLI");
        $('#DestinationCity').val("LAS");
        $('#PassengersCount').val(2);
        $('#Bag').prop('checked', false);
        $('#Pet').prop('checked', false);
        $('#Hotel').prop('checked', false);
        $('#Car').prop('checked', false);
        $('#CardNumber').val("9874-7894-8478-5489");
        $('#Cardmonth').val("March");
        $('#Cardday').val(faker.random.number({ 'min': 1, 'max': 28 }));
        $('#Cardyear').val(yearArr[3]);
        $('#CardCVV').val(faker.random.number({ 'min': 200, 'max': 900 }));
        chrome.storage.sync.remove('depCity')
        chrome.storage.sync.remove('desCity')
        chrome.storage.sync.remove('PassengersCount')
        chrome.storage.sync.remove('paxDetails')
        chrome.storage.sync.remove('dateArr')
        chrome.storage.sync.remove('addBag')
        chrome.storage.sync.remove('addHotel')
        chrome.storage.sync.remove('addCar')
        chrome.storage.sync.remove('cardNum')
        chrome.storage.sync.remove('cardCVV')
        chrome.storage.sync.remove('expMonth')
        chrome.storage.sync.remove('expDay')
        chrome.storage.sync.remove('expYear')
        chrome.storage.sync.remove('Billcountry')
        chrome.storage.sync.remove('BillstreetAdd')
        chrome.storage.sync.remove('Billstreet2')
        chrome.storage.sync.remove('BillCity')
        chrome.storage.sync.remove('BillzipCode')
        chrome.storage.sync.remove('Billphone')
        chrome.storage.sync.remove('BillMail')
    })

    $("#CardNumber").on("keydown", function(e) {
        var cursor = this.selectionStart;
        if (this.selectionEnd != cursor) return;
        if (e.which == 46) {
            if (this.value[cursor] == " ") this.selectionStart++;
        } else if (e.which == 8) {
            if (cursor && this.value[cursor - 1] == " ") this.selectionEnd--;
        }
    }).on("input", function() {
        var value = this.value;
        var cursor = this.selectionStart;
        var matches = value.substring(0, cursor).match(/[^0-9]/g);
        if (matches) cursor -= matches.length;
        value = value.replace(/[^0-9]/g, "").substring(0, 16);
        var formatted = "";
        for (var i=0, n=value.length; i<n; i++) {
            if (i && i % 4 == 0) {
                if (formatted.length <= cursor) cursor++;
                formatted += "-";
            }
            formatted += value[i];
        }
        if (formatted == this.value) return;
        this.value = formatted;
        this.selectionEnd = cursor;
    });

    $("#PassengersCount").on("input",function(){
        let num = this.value;
        if(num>9){
            this.value=9;
        }else if(num<1){
            this.value=1;
        }
    })

    $("#CardCVV").on("input",function(){
        let cvvVal = this.value;
        if(cvvVal.length>3){
            this.value=cvvVal.substring(0,3);
        }
    })

    $("#Cardday").on("input",function(){
        let dayVal = this.value;
        if(dayVal>28){
            this.value=28;
        }else if(dayVal<1){
            this.value=1;
        }
    })

    $("#Cardyear").on("input",function(){
        let yearVal = this.value;
        if(yearVal.length>4){
            this.value=yearVal.substring(0,4);
        }
    })
})

