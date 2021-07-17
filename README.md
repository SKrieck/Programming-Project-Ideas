# Programming-Project-Ideas
This is a program I wrote for myself to save and retrieve programming ideas. I can add, delete, and print ideas as well as randomizing which project to do next! Free free to use it for yourself.

I've learned about formatting variables written to files as well as formatting them for the user to print. File handling was the biggest hurdle, since I couldn't figure out which data structure would be best for what I wanted to accomplish. After trying ArrayList<> and a regular Array, I decided to use the hybrid list. It gave me the functions to format my files as well as the ability to easily write to them.
The hardest part was figuring out how to delete from an Array then copying to a List for file saving. I know an ArrayList would have been a better and easier choice, however I could not get it to function properly for my needs.
**Addendum** In my delete section, I was unaware that the best way to traverse a list is the Iterator. Using an Iterator to traverse over the List newProjectsArray, I easily removed the elements needed. (And the code looks nicer as well.)

As of right now, all of the options work. However, it needs additional polish which will be in my next version.
  - User errors need to be handled
  - Checking if there is a duplicate idea entered

If you post any part of this code, please reference back to me. Thanks and enjoy!
