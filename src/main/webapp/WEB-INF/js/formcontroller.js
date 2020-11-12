"use strict"; {

    const root = document.getElementById("root");
    const fornavn = document.querySelector('#fornavn');
    const etternavn = document.querySelector('#etternavn');
    const mobil = document.querySelector('#mobil');
    const passord = document.querySelector('#passord');
    const passordRepetert = document.querySelector('#passordRepetert');
    const passord_info = document.querySelector('div[data-info="passord"]');
    const submit_info = document.querySelector('div[data-info="submit"]');

    passord_info.classList.add("formcontroller_hidden");
    submit_info.classList.add("formcontroller_hidden");

    root.addEventListener('submit', (e) => {
        if(fornavn.value.length < 2 || fornavn.value.length > 20 || etternavn.value.length < 2 || etternavn.value.length > 20 || mobil.value.length != 8 || passord.value != passordRepetert.value || passord.value.lenght < 6 ){
            e.preventDefault()
            submit_info.classList.remove("formcontroller_hidden");
            submit_info.classList.add("formcontroller_weakPassword");
            submit_info.innerHTML = "Her skrev du noe feil";
        } else {
            submit_info.classList.add("formcontroller_hidden");
        }
    });

    function checkText(input){
        const a = /^[A-ZÆØÅ][a-zæøåA-ZÆØÅ]+$/;

        if(input.value.match(a)){
            
        } else {
            input.classList.remove("formcontroller_validInput");
            input.classList.add("formcontroller_invalidInput");
        }
    }

    function checkNumber(input){
        const a = /^[0-9]+$/;

        if(input.value.match(a)){
            
        } else {
            input.classList.remove("formcontroller_validInput");
            input.classList.add("formcontroller_invalidInput");
        }
    }

    $('#fornavn').on('input', function() {

        if (fornavn.value.length < 2 || fornavn.value.length > 20 ) {
            fornavn.classList.remove("formcontroller_validInput");
            fornavn.classList.add("formcontroller_invalidInput");
            checkText(fornavn);
        } else {
            fornavn.classList.remove("formcontroller_invalidInput");
            fornavn.classList.add("formcontroller_validInput");
            checkText(fornavn);
        }
    })

    $('#etternavn').on('input', function() {

        if (etternavn.value.length < 2 || etternavn.value.length > 20 ) {
            etternavn.classList.remove("formcontroller_validInput");
            etternavn.classList.add("formcontroller_invalidInput");
            checkText(etternavn);
        } else {
            etternavn.classList.remove("formcontroller_invalidInput");
            etternavn.classList.add("formcontroller_validInput");
            checkText(etternavn);
        }
    })

    $('#mobil').on('input', function() {

        if (mobil.value.length == 8) {
            mobil.classList.remove("formcontroller_invalidInput");
            mobil.classList.add("formcontroller_validInput");
            checkNumber(mobil);
        } else {
            mobil.classList.remove("formcontroller_validInput");
            mobil.classList.add("formcontroller_invalidInput");
            checkNumber(mobil);
        }
    })

    $('#passord').on('input', function() {

        if (passord.value.length <= 7) {
            passord.classList.remove("formcontroller_mediumPassword");
            passord.classList.remove("formcontroller_strongPassword");
            passord.classList.add("formcontroller_weakPassword");
        } else if(passord.value.length <= 10) {
            passord.classList.remove("formcontroller_weakPassword");
            passord.classList.remove("formcontroller_strongPassword");
            passord.classList.add("formcontroller_mediumPassword");
        } else {
            passord.classList.remove("formcontroller_weakPassword");
            passord.classList.remove("formcontroller_mediumPassword");
            passord.classList.add("formcontroller_strongPassword");
        }
    })

    $('#passordRepetert').on('input', function() {

        if (passord.value == passordRepetert.value) {
            passordRepetert.classList.remove("formcontroller_invalidInput");
            passordRepetert.classList.add("formcontroller_validInput");
        } else {
            passordRepetert.classList.remove("formcontroller_validInput");
            passordRepetert.classList.add("formcontroller_invalidInput");
        }
    })

    $('#passord').mouseover(function(){
        if (passord.value.length <= 7) {
            passord_info.innerHTML = "Dette er et svakt passord";
            passord_info.classList.remove("formcontroller_mediumPassword");
            passord_info.classList.remove("formcontroller_strongPassword");
            passord_info.classList.add("formcontroller_weakPassword");
        } else if(passord.value.length <= 10) {
            passord_info.innerHTML = "Dette er et middels passord";
            passord_info.classList.remove("formcontroller_weakPassword");
            passord_info.classList.remove("formcontroller_strongPassword");
            passord_info.classList.add("formcontroller_mediumPassword");
        } else {
            passord_info.innerHTML = "Dette er et sterkt passord";
            passord_info.classList.remove("formcontroller_weakPassword");
            passord_info.classList.remove("formcontroller_mediumPassword");
            passord_info.classList.add("formcontroller_strongPassword");
        }
        passord_info.classList.remove("formcontroller_hidden");
    });
    $('#passord').mouseout(function(){
        passord_info.classList.add("formcontroller_hidden");
    });

}