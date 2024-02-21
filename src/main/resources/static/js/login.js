var isRegister = false


function passwordCheckbox(event) {
    var passwordInput = document.getElementById('passwordInput');
    passwordInput.type = event.srcElement.checked ? 'text' : 'password';
}


function login(event) {
    console.log("into login function")
    event.preventDefault();
    const usernameInput = document.getElementById('Username');
    const emailInput = document.getElementById('inputContainer');
    var passwordInput = document.getElementById('passwordInput');


    console.log("username -", usernameInput?.value)
    console.log("email -", emailInput?.value)
    console.log("password", passwordInput?.value)

    if(isRegister){
        fetch("http://localhost:8080/api/user/register", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify({name: usernameInput.value, email: emailInput.value,password: passwordInput.value
            })
        })
        .then(response => {
            if (response.ok) {
                console.log("test - success", response)
                alert("User registered successfully")
                // Redirect to another page
                window.location.href = "http://localhost:8080/all";
                return response
            } else if(response.status == 400){
                console.log("test - User exist")
                alert(response)
                toggleInputField();
            }else {
                console.log(response)
                throw new Error("Failed to fetch data");
            }
        })
        .then(data => {
            console.log("Data received:", data);
            // Do something with the received data
        })
        .catch(error => {
            console.error("Error:", error);
        });
    }else{
        fetch("http://localhost:8080/api/user/login",
            {
                method: "POST",
                headers: {
                    "Content-Type": "application/json"
                },
                body: JSON.stringify({name: usernameInput.value, email: emailInput.value, password: passwordInput.value
                })
            })
            .then(response => {
                if (response.ok) {
                    console.log("test - login- success", response)
                    alert("User logged in successfully")
                    // Redirect to another page
                    window.location.href = "http://localhost:8080/all";
                    return response
                }else if(response.status == 404){
                    //user not found redirect to signup page
                    alert("User doesn't exist, please Sign-up!")
                    toggleInputField()
                }else if(response.status == 400){
                    //user credentials incorrect
                    alert("User credentials incorrect, please enter correct details")
                    window.location.href = "http://localhost:8080/";
                }else {
                    console.log(response)
                    throw new Error("Failed to fetch data");
                }
            })
            .then(data => {
                console.log("Data received:", data);
                // Do something with the received data
            })
            .catch(error => {
                console.error("Error:", error);
            });
    }

}



// Function to toggle creation/deletion of input field
function toggleInputField(event) {
    const toggleInputButton = document.getElementById("toggleInput");
    const inputContainer = document.getElementById("inputContainer");
    if (!isRegister) {
      const newInput = document.createElement("input");
      newInput.type = "email";
      newInput.style.fontFamily = "Rubik";
      newInput.style.width = "100%";
      newInput.style.padding = "10px";
      newInput.style.margin = "10px 0";
      newInput.style.border = "1px solid #435B66";
      newInput.style.borderRadius = "5px";
      newInput.style.alignItems = "center";
      newInput.style.backgroundColor = "#B6BBC4";
      newInput.style.boxShadow = "0 0 10px rgba(0, 0, 0, 0.2)";
      newInput.style.color = "#fff";
      newInput.placeholder = "Email";
      inputContainer.appendChild(newInput);
      isRegister = true;

      // Remove event listener from the toggleInputButton
      toggleInputButton.removeEventListener("onclick", toggleInputField);
      changeLoginToSubmit();
    }
    const signupButton = document.getElementById("toggleInput")
    signupButton.disabled = true
    signupButton.classList.add("disabled")
}

function changeLoginToSubmit(){
    const loginButton = document.getElementById("login-button");
    loginButton.innerHTML = "Submit";
}