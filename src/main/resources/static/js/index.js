'use strict';

window.addEventListener('DOMContentLoaded',()=>{

const button = document.querySelector('.button');
const translated = document.querySelector('#translated');
const arrows = document.querySelector('#arrows');
const textElement = document.querySelector('#input-text');
const sourceElement = document.querySelector('#source-select');
const targetElement = document.querySelector('#target-select');

const languageMap = new Map([
    ["English","en"], ["Chinese","zh"], ["Danish","da"], ["Finnish","fi"], ["German","de"], ["Italian","it"],
    ["Japanese","ja"], ["French","fr"], ["Polish","pl"], ["Ukrainian","uk"],["Georgian","ka"],["Greek","el"],
    ["Irish","ga"],["Hindi","hi"],["Latvian","lv"],["Lithuanian","lt"],["Ukrainian","uk"],["Romanian","ro"],
    ["Slovak","sk"],["Slovenian","sl"],["Spanish","es"],["Swedish","sv"],["Turkish","tr"]
]);

let languageArray = Array.from(languageMap, ([key, value]) => ({ key: key, value: value }));

button.addEventListener('click', translate);
arrows.addEventListener('click', swap);
sourceElement.addEventListener('change', changeSelect);


fillSelect(languageArray,sourceElement);
fillSelect(languageArray.slice(1,languageArray.length),targetElement);

function fillSelect(languageArray,selectElement){
    languageArray.forEach((element) => {
        let option = document.createElement("option");
        option.text = element.key;
        option.value = element.value;
        selectElement.appendChild(option);
    });
}

function changeSelect(e,value){
    let sourceValue = sourceElement.value;
    let targetValue = targetElement.value;
    targetElement.innerHTML=null;
    fillSelect(languageArray.filter( element => {
        return element.value != sourceValue;
    }),targetElement);
    
    if(sourceValue != targetValue){
        targetElement.value = targetValue;
    }

    if(value){
        console.log(value);
        targetElement.value = value;
    }

    e.preventDefault();
}

function translate(event){
    let text = textElement.value;
    let source = sourceElement.value;
    let target = targetElement.value;

    if(text && source && target){

        let data = {
            "text": text,
            "sourceLang": source,
            "targetLang": target
        };

        let xhttp = new XMLHttpRequest();
        let url = "http://localhost:8080/api/v1/translate";

        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {

                let response = xhttp.responseText;
                response ? translated.innerHTML=response : translated.innerHTML="something went wrong...";

            }else if(this.status == 400){
                translated.innerHTML="something went wrong...";
            }
        };

        if(data) url =  url + '?' +
            Object
                .keys(data)
                .map(function (key) { return [key, data[key]].map(encodeURIComponent).join("="); })
                .join("&");

        xhttp.open("GET", url, true);
        xhttp.setRequestHeader("Accept", 'application/json; charset=UTF-8');
        xhttp.setRequestHeader("Content-Type", 'application/json; charset=UTF-8');

        xhttp.send();
    }
    
    event.preventDefault();
}

function swap(event){
    let sourceValue = sourceElement.value;
    let targetValue = targetElement.value;

    sourceElement.value = targetValue

    let translatedValue = translated.innerHTML;
    let textValue = textElement.value;

    if(textValue && translatedValue && translatedValue != 'translated text'){
        textElement.value = translatedValue;
        translated.innerHTML = textValue; 
    }

    changeSelect(event,sourceValue);
}

});