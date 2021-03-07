var registerForm =document.getElementById("login-form");
var API_url = window.location.origin+"/Proyecto_Web_II_Cesar/Login"

registerForm.addEventListener("submit", send);


function send (e) {
    e.preventDefault();
    var data = {};
    var form = new FormData(registerForm);
    for(var pair of form.entries()) {
        data[pair[0]] = pair[1];
     }
    console.log(data)

	fetch(API_url, {
        method: 'POST', // or 'PUT'
        body: form,
      }).then(res => res.json())
      .catch(error => console.error('Error:', error))
      .then(response => console.log('Success:', response));
}