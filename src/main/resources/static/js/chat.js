var input = document.getElementById("chat-input");

input.addEventListener("keypress", function(event){
    if(event.key === "Enter") {
        event.preventDefault();
        sendMessage();
    }
})


function sendMessage() {
  var messageInput = document.getElementById("chat-input");
  var message = messageInput.value;

  if (message.trim() !== "") {
      var chatContainer = document.getElementById("chat-container");
      var messageDiv = document.createElement("div");
      messageDiv.className = "message";
      messageDiv.innerText = message;
      chatContainer.appendChild(messageDiv);

      chatContainer.scrollTop = chatContainer.scrollHeight;

      // Clear input field after sending message
      messageInput.value = "";
  }
}

