window.calResult;
window.memoryState;
var xmlhttp = new XMLHttpRequest();

function send() {
  var a = document.querySelector('#valor1').value;
  var b = document.querySelector('#valor2').value;
  var op = document.querySelector('input[name="operacion"]:checked').value;

  xmlhttp.onreadystatechange = function() {
    console.log(xmlhttp.status);
    if (xmlhttp.readyState==4 && xmlhttp.status==200){
     console.log(xmlhttp.responseText);
     calResult = xmlhttp.responseText;
    }
  }

  xmlhttp.open("GET","http://localhost:8080/RESTCalculator/rest/calculator/" + op + "/" + a + "/" + b, true);
  xmlhttp.send();
}

function memoryHandler(element) {
  var m = element.id;

  xmlhttp.onreadystatechange = function() {
    console.log(xmlhttp.status);
    if (xmlhttp.readyState==4 && xmlhttp.status==200){
     console.log(xmlhttp.responseText);
     memoryState = xmlhttp.responseText;
    }
  }

  if (m.length > 2) {
    xmlhttp.open("GET","http://localhost:8080/RESTCalculator/rest/calculator/" + m + "/" + a, true);
  }else {
    xmlhttp.open("GET","http://localhost:8080/RESTCalculator/rest/calculator/" + m, true);
  }

  xmlhttp.send();
}
