# CS 1 Review

Hello user! I have rewritten this program to be free of errors, and function as intented. Here are some of the edits I made:
1. The Student constructor was not properly named and therefore didn't function.
2. Added a default constructor to Student
3. Changed the givenName and familyName to have consistent letter casing.
4. Changed the getGrades function so that it returns a copy instead of the original referrence.
5. Fixed average() by editing the foreach loop with correct types and changing the String of grades to Ints using .parse
6. Added a throw FNFE for directory class.
7. Throw an IAE if you have any null data.
8. public properties are now private in student.
9. Edited the indexing for the student directory so it no longer over or under indexes the file and forgets a student.

And maybe some more. The program can now, when given a proper file template. Return a formatted list of student info including year, average grade etc.
Passes test successfully.

Author: Chance Haley