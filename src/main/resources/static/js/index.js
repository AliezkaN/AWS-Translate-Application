'use strict';

var button = document.querySelector('.button');
var translated = document.querySelector('#translated');
var arrows = document.querySelector('#arrows');

function translate(event){
    let text = document.querySelector('#input-text').value;
    let source = document.querySelector('#source-select').value;
    let target = document.querySelector('#target-select').value;


    if(text && source && target){

        var data = {
            "text": text,
            "sourceLang": source,
            "targetLang": target
        };
        var xhttp = new XMLHttpRequest();
        var url = "http://localhost:8080/api/v1/translate";

        

        xhttp.onreadystatechange = function() {
            if (this.readyState == 4 && this.status == 200) {
                let response = xhttp.responseText;
                if(response){
                    translated.innerHTML=response;
                }else{
                    translated.innerHTML="something went wrong...";
                }
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
    let source = document.querySelector('#source-select');
    let target = document.querySelector('#target-select');
    let temp = source.value;
    source.value = target.value;
    target.value = temp;

    let text = document.querySelector('#input-text');
    
    let translatedValue = translated.innerHTML;
    let textValue = text.value;

    if(textValue && translatedValue && translatedValue != 'translated text'){
        text.value = translatedValue;
        translated.innerHTML = textValue; 
    }

    event.preventDefault();
}

button.addEventListener('click', translate);
arrows.addEventListener('click', swap);