window.calResult;
window.memoryState;
var xmlhttp = new XMLHttpRequest();

if (typeof localStorage.memory == 'undefined') {
  localStorage.memory = 0;
}

function send() {
  var a = document.querySelector('#valor1').value;
  var b = document.querySelector('#valor2').value;
  var op = document.querySelector('input[name="operacion"]:checked').value;

  xmlhttp.onreadystatechange = function() {
    console.log(xmlhttp.status);
    if (xmlhttp.readyState==4 && xmlhttp.status==200){
      console.log(xmlhttp.responseText);
      calResult = xmlhttp.responseText;
      var result = document.querySelector('#resultado');
      result.innerHTML = 'Resultado: ' + calResult;
    }
  }

  xmlhttp.open("GET","http://localhost:8100/RESTCalculator/rest/calculator/" + op + "/" + a + "/" + b, true);
  xmlhttp.send();
}

var button = document.querySelector('#makeIt');
button.addEventListener('click', send)

function memoryHandler(element) {
  var m = element.id;

  switch (element.id) {
    case 'mc':
      localStorage.memory = 0;
      break;
    case 'mr':
      var mem = document.querySelector('#memoria');
      mem.innerHTML = 'Memoria: ' + localStorage.memory;
      break;
    case 'mplus':
      localStorage.memory = parseFloat(localStorage.memory) + parseFloat(calResult);
      break;
    case 'mminus':
      localStorage.memory = parseFloat(localStorage.memory) + parseFloat(calResult);
      break;
    default:
      alert('Valor inesperado')
  }

  xmlhttp.onreadystatechange = function() {
    console.log(xmlhttp.status);
    if (xmlhttp.readyState==4 && xmlhttp.status==200){
     console.log(xmlhttp.responseText);
     memoryState = xmlhttp.responseText;
    }
  }

  if (m.length > 2) {
    xmlhttp.open("GET","http://localhost:8100/RESTCalculator/rest/calculator/" + m + "/" + calResult, true);
  }else {
    xmlhttp.open("GET","http://localhost:8100/RESTCalculator/rest/calculator/" + m, true);
  }

  xmlhttp.send();
}
