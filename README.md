# Swing-Calculator
Purely built in Java using lightweight Swing components.

All the other calculors I found on GitHub were either not as expected or were full of bugs. So, I took up the responsibility to make one.
If you find any bug in this calculator then either inform me about it or simply fix it and tell me about your accomplishment. I'll update it with your improvements.

**I've purposefully commented out the lines which were intended to restrict the user from entering any alphabets into the TextFields.
Because MyIntFilter.java has a logical bug at the of its initial commit. The bug is that if once the number is entered into a TextField,
the very first number remains undeleted when the BACKSPACE is pressed**

*For example.*

Entered number: 49566

On pressing *BACKSPACE* 5 times the first number i.e. 4 in this case remains there as it is.

**IN CONCLUSION, SO FAR THE BUGS THAT I FOUND ARE:**
* The one above discussed.
* cos(toRadians(90)) is not equal to 1 but equals to <i>'6.123233995736766E-17'</i>

If you could fix all these the bug, ***OH WELL!*** I'll be the happiest person alive.

Thanks for reading. Have a nice day!
