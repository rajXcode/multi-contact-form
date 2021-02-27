class FormValidator {
    constructor(form, fields) {
      this.form = form
      this.fields = fields
    }
   
    initialize() {
      if (document.readyState === 'loading') {  // Loading hasn't finished yet
    } else {  // `DOMContentLoaded` has already fired
    document.addEventListener('DOMContentLoaded',  this.validateOnEntry());
    }
    }

    validateOnEntry() {
      let self = this
      this.fields.forEach(field => {
        const input = document.getElementById(field);
        console.log(input)
        input.addEventListener('input', event => {
          console.log("event",event);
          self.validateFields(input)
        })
      })
    }
  }

  const form = document.querySelector('.form')
  const fields = ["name", "email", "number"]
  let finalStatus = false;
  const validator = new FormValidator(form, fields)
  validator.initialize()

   function validateOnSubmit() {
      const fields = ["name", "email", "number"]
      let self = this

          fields.forEach(field => {
          const input = document.getElementById(field)
          validateFields(input)
        })
        return;

    }

    function validateFields(field) {

      // Check presence of values
      if (field.value.trim() === "") {
        this.setStatus(field, "Cannot be blank", "error")
      } else {
        this.setStatus(field, null, "success")
      }

      // check for a valid email address
      if (field.type === "email") {
        const re = /\S+@\S+\.\S+/
        if (re.test(field.value)) {
          this.setStatus(field, null, "success")
        } else {
          this.setStatus(field, "Please enter valid email address", "error")
        }
      }

      // Password confirmation edge case
      if (field.id === "number") {
        if (field.value.trim() == "") {
          this.setStatus(field, "Phone Number Required", "error")
        } else if (!isNumber(field.value)) {
          this.setStatus(field, "Please enter number only", "error")
        } else {
          this.setStatus(field, null, "success")
        }
      }
    }

  function validateForm() {
      const name = document.getElementById("name")
      const email = document.getElementById("email")
      const number = document.getElementById("number")

      // Check presence of values
      if (name.value.trim() === "") {
        alert("Name cannot be blank!")
        return
      }

      // check for a valid email address
      if (email.type === "email") {
        const re = /\S+@\S+\.\S+/
        if (name.value.trim() === "") {
          alert("Email cannot be blank!")
          return
        } else if (re.test(email.value)) {
  //        this.setStatus(field, null, "success")
        } else {
            alert("Please enter valid email address!")
            return
        }
      }

      if (number.id === "number") {
        if (number.value.trim() == "") {
          alert("Phone number required!")
          return
        } else if (!isNumber(number.value)) {
          alert("Please enter number only!")
          return
        }
      }
    }


  function setStatus(field, message, status) {
  
    const successIcon = field.parentElement.querySelector('.icon-success')
    const errorIcon = field.parentElement.querySelector('.icon-error')
    const errorMessage = field.parentElement.querySelector('#error'+field.id)

    if (status === "success") {
      if (errorIcon) { errorIcon.classList.add('hidden') }
      if (errorMessage) { errorMessage.innerText = "" }
      successIcon.classList.remove('hidden')
      field.classList.remove('input-error')
      finalStatus = true;
    }

    if (status === "error") {
      if (successIcon) { successIcon.classList.add('hidden') }
//      field.parentElement.querySelector('.error-message').innerText = message
      field.parentElement.querySelector('#error'+field.id).innerText = message
      errorIcon.classList.remove('hidden')
      field.classList.add('input-error')
      finalStatus = false;
    }
  }

  function  isNumber(n){
    return (parseFloat(n) == n);
  }


  function sendJSON(){    
    if (finalStatus == false){
      console.log("Error in form");
      return;
    }
    let name = document.getElementById("name")
    let email = document.getElementById("email")
    let phone = document.getElementById("number")
       
    // Creating a XHR object 
    let xhr = new XMLHttpRequest(); 
    let url = "localhost:8082/save-contact";

    // open a connection 
    xhr.open("POST", url, true); 

    // Set the request header i.e. which type of content you are sending 
    xhr.setRequestHeader("Content-Type", "application/json"); 

    // Create a state change callback 
    xhr.onreadystatechange = function () { 
        if (xhr.readyState === 4 && xhr.status === 200) { 

            // Print received data from server 
            result.innerHTML = this.responseText; 

        } 
    }; 

    // Converting JSON data to string 
    var data = JSON.stringify({ "name": name.value, "email": email.value, "number": phone.value}); 
    console.log(data);
    // Sending data with the request 
    xhr.send(data); 
} 