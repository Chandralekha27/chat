const chatContainer = document.getElementById('chat-container');
const input = document.getElementById('chat-input');
let userInput = '';

// Event listener for input changes
input.addEventListener('input', function(event) {
  userInput = event.target.value; // Store user input
});

// Event listener for Enter key press
input.addEventListener('keypress', function(event) {
  if (event.key === 'Enter') {
    event.preventDefault();
    const text = userInput.trim();
    if (text !== '') {
      createChatBubble(text); // Create chat bubble from user input
      userInput = ''; // Reset user input
    }
  }
});

function createChatBubble(text) {
  const bubble = document.createElement('div');
  bubble.classList.add('chat-bubble');
  bubble.textContent = text;
  chatContainer.insertBefore(bubble, input); // Insert chat bubble above the input field
}
