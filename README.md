# r/dailyprogrammer Challenges

This repo contains my attempts at some of the challenges found on [reddit's r/dailyprogrammer](https://www.reddit.com/r/dailyprogrammer/).

- #374 [Easy] : Additive Persistence
- #369 [Easy] : RGB to Hex Colour
- #353 [Intermediate] : Pancake Sorting
- #362 [Intermediate] : Transposition Cipher
- #381 [Easy] : Yahtzee Upper Scoring


## Additive Persistence
To find the additive persistence of a number is to sum the individual digits of the number, repeat and
sum the individual digits of the first sum, and so on until the result is only a single digit. This resulting
number is the root persistence, and the number of times the process was repeated is the additive persistence.

Example:
483,293 -> 29 -> 11 -> 2

From the number 483,293, the root persistence would be 2, and the additive persistence would be 3

To sum the digits we can cast the number into a string, index each number and add the values together, but it is possible to do this without using strings.

By using 'result += number % 10' we will add the least significant digit to result. Then we can divide number
by 10 and repeat both steps, until number is < 10. After number < 10, this will be one cycle towards the additive
persistence so we can increase our count. Repeat this entire process until the result is < 10.


## RGB to Hex Colour
RGB and Hex colour formats are very similar when broken down. They both represent the colours red, green, blue
in the format RR.GG.BB. The difference between the two is that in RGB the values of each component range from
0-255, where a lower value is closer to black and a higher is closer to white. For Hex this range would be
from 0-FF.

To convert between the two, all we need is to convert each RGB component from an integer to a hex value and
concatenate the results.


## Pancake Sorting
The premise behind Pancake Sorting is having a stack of n pancakes with varying sizes. The pancakes start in
a random order and are considered sorted when the pancakes are stacked from smallest at the top, and largest
at the bottom.

The rules for sorting the pancakes is that we can only do it by flipping substacks of the pancakes where we
flip all the pancakes from the top, down to chosen pancake. An example of this would be:

| Pancakes | Action |
| --- | --- |
| (B) 9, 3, 7, 4   (T) | Unsorted |
| (B) 9, 3, [7, 4] (T) | Selection #1 |
| (B) 9, 3, 4, 7   (T) | Flip #1 |
| (B) 9, [3, 4, 7] (T) | Selection #2 |
| (B) 9, 7, 4, 3   (T) | Flip #2 |
| (B) 9, 7, 4, 3   (T) | Sorted |

We flip all the pancakes in the selection, not touching those "underneath". The trick to sorting the pancakes
is to search through all the pancakes and find the largest. If the largest is not already at the bottom, we
want to flip it to the top of the pile. Now since the selected pancake is at the top, we can place it
anywhere in the stack so we will place it either on the bottom or on top of the pancake that is one size larger
which would be already sorted.

Repeating this process we can stack the largest pancakes up slowly and narrow our search as we don't need to
include sorted pancakes in any following flips.


## Transposition Cipher
A Transpositon Cipher is a way of encrypting messages by rearranging the letters by entering themessage into
a rectangle and recording the letters as you sprial through the rectangle.

For instance the message "WE ARE DISCOVERED. FLEE AT ONCE" is first stripped of whitespace and punctuation,
although this is option and can be left in. If we are using a 9x3 rectangle and rotating clockwise would look
like:

| C | I | P | H | E | R |  | | |
| -- | -- | -- | -- | -- | -- | -- | --| -- |
|  |  |  |  |  |  |  | |  |
| W | E | A | R | E | D | I | S | C |
| O | V | E | R | E | D | F | L | E |
| E | A | T | O | N | C | E | X | X |

Starting from the top right (C), we will spiral clockwise recording each letter into the ciphered message:

"CEXXECNOTAEOWEAREDISLFDEREV"

It should be noted that this Transposition Cipher only encrypts messages and doesn't include a way to decrpyt
messages.


## Yahtzee Upper Scoring
The Yahtzee Upper Scoring section has a place to record a score for each side of a die (1-6). A score can for
each side of the die can only include the dice rolled that had that value.

Example: If we rolled 6 dice and had the result:

3, 5, 6, 6, 3, 6

Our possible scoring would be:

Side | Amount | Score
| -- | -- | -- |
3 | x2 | 6
5 | x1 | 5
6 | x3 | 18

18 is the largest possible score from our roll and would be returned from the function.




