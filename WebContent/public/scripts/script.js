var registerForm =document.getElementById("register-form");
var API_url = 'http://localhost:8080/Proyecto_Web_II_Cesar/Register'

registerForm.addEventListener("submit", send);


function send (e) {
    e.preventDefault();
    var data = {};
    var form = new FormData(registerForm);
    for(var pair of form.entries()) {
        data[pair[0]] = pair[1];
     }
    console.log(data)
/*
    fetch(API_url, {
        method: 'POST', // or 'PUT'
        body: JSON.stringify(data), // data can be `string` or {object}!
        headers:{
          'Content-Type': 'application/json; charset=UTF-8'
				
        }
      }).then(res => res.json())
      .catch(error => console.error('Error:', error))
      .then(response => console.log('Success:', response));
*/

	fetch(API_url, {
        method: 'POST', // or 'PUT'
        body: form,
      }).then(res => res.json())
      .catch(error => console.error('Error:', error))
      .then(response => console.log('Success:', response));
}