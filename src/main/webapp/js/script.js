/**
 * 
 */
function disable(x)
{
    x.disabled = false;
}
// Get references to the textarea and the character count element
const textArea = document.getElementById('message');
const charCount = document.getElementById('countRemainingcharaters');

// Initialize the character count
let count = 0;
let maxCount = charCount.textContent; 
// Add an input event listener to the textarea
textArea.addEventListener('input', function (event) {
    // Get the text from the textarea
    const text = textArea.value;

    // Calculate the change in character count
    const delta = text.length - count;

    // Update the character count
    count = text.length;

    // If characters were deleted, ensure the count is never negative
    if (delta < 0) {
        count = Math.max(count, 0);
    }
    if(count>=maxCount){
        event.preventDefault(); // Prevent the default input behavior
        textArea.value = text.substring(0, maxCount); // Truncate the text
    }
    // Update the character count element
    
    charCount.textContent = maxCount - count;

    if(charCount.textContent<0){
        charCount.textContent=0;
    }
});