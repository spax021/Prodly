# Prodly

**1. A username textbox on our platform should be able to take characters from basic latin alphabet, greek alphabet and cyrillic alphabet.
**

**a) A bug was reported that entering “monsterUser” as username in the registration screen, will return an “Invalid username” message.
The bug was forwarded to the developers who generated a fix.
Please write your test cases to validate the functionality of the textbox.**

**TC1_A:**
Verify user is able to use characters from Latin alphabet on registration screen
Example input: monsterUser
Expected result: System is accepting username without errors

**TC2_A:**
Verify user is able to use characters (ALL CAPS) from Latin alphabet on registration screen
Example input: MONSTERUSER
Expected result: System is accepting username without errors

**TC3_A:**
Verify user is able to use characters from Greek alphabet on registration screen
Example input: τέρας χρήστης
Expected result: System is accepting username without errors

**TC4_A:**
Verify user is able to use characters from Cyrillic alphabet on registration screen
Example input: монстерусер
Expected result: System is accepting username without errors

**b) Entering anything besides the three alphabets mentioned above should return “Invalid username” to the user.
Please write the test cases you would append to your test suite in order to test this text box
before every release**

**TC1_B:**
Verify user is unable to use only numbers on registration screen
Example input: 
Expected result: Return "Invalid username."

**TC2_B:**
Verify user is unable to use special characters on registration screen
Example input: 
Expected result: Return "Invalid username."

**TC3_B:**
Verify user is unable to use characters outside the specified alphabets (ex Arabic) on registration screen
Example input: مستخدم
Expected result: Return "Invalid username."

**TC4_B:**
Verify user is unable to use mix of valid and invalid characters on registration screen
Example input: MonsterUser@123
Expected result:  Return "Invalid username."



** 2. You were testing the phone before release and found out that if you put the speaker phone “on” after dialling a number, the phone restarts hence preventing you from establishing communication.
Write a bug report with all the necessary information to help the developer generate a fix for this bug.
**
**Title:** Phone restarts when Speakerphone is activated after dialling a number

**Precondition:**
Phone is in idle mode, connected to power source with strong signal

**Description:**
When user dials phone number and while the number is dialling user press speaker button, phone restarts and prevents establishing a connection

Issue found on {{phone_model}} with firmware version {{firmware_version}}

**Additional:** 
Issue does not occur if speakerphone is activated before dialling
Issue does not occur if speakerphone is activated after call is established

**Steps to reproduce:**
Enter valid phone number
Press Dial
While phone is dialling, press speaker button

**Expected result:**
The call is established without any interruption to the call

**Actual result:**
As soon as speakerphone is activated, phone restarts and call is dropped

**Severity:** High
**Priority:** High

*Logs and screenshots are attached to the bug ticket accordingly


**3.Our company’s product is electronic window shutters. The company instals one shutter on a window and provides you with a remote that has 3 buttons. Up/Down/Stop
Generate the test suite (only summary no steps required) that all shutters must undergo before they are delivered to the customer (assume all electrical connections are fine).**

Verify that button UP is raising  the shutters
Verify that button DOWN is lowering the shutters
Verify that button STOP is stopping any movement
Verify maximum range of remote (defined by manufacture)
Verify that only dedicated remote can activate shutter
Verify functionality of a remote through various barriers (Walls, glass, etc.)
Verify endurance of shutters after continuously raising and lowering with remote
Verify that shutters return to default state in case of power failure (or previous)
Verify that shutters can be lowered and raised manually
Verify that shutters move in designated speed without any lag
Verify that button on remote are clearly labelled and user friendly
