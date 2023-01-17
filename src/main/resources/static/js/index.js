'use strict';

let button = document.querySelector('.button');
let translated = document.querySelector('#translated');
let arrows = document.querySelector('#arrows');
let textElement = document.querySelector('#input-text');
let sourceElement = document.querySelector('#source-select');
let targetElement = document.querySelector('#target-select');

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

        xhttp.open("POST", url, true);
        xhttp.setRequestHeader("Accept", 'application/json; charset=UTF-8');
        xhttp.setRequestHeader("Content-Type", 'application/json; charset=UTF-8');

        xhttp.send(JSON.stringify(data));
    }
    
    event.preventDefault();
}

function swap(event){
    let temp = sourceElement.value;
    sourceElement.value = targetElement.value;
    targetElement.value = temp;

    let translatedValue = translated.innerHTML;
    let textValue = textElement.value;

    if(textValue && translatedValue && translatedValue != 'translated text'){
        textElement.value = translatedValue;
        translated.innerHTML = textValue; 
    }

    event.preventDefault();
}

button.addEventListener('click', translate);
arrows.addEventListener('click', swap);