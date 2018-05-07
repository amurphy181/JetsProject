## Jets Projects
### Week 2 Skill Distillery Homework Project

#### Description

This basic air field simulator allows you to track and add both aircraft and pilots to simulated hangars and airman quarters. Using a menu system inside of a loop, the user can call on methods to perform all of the needed actions for management of an air fleet, then exit once finished.

At this time, planes and airmen added throughout the running of the program do not persist, so exiting and re-opening sets both back to the hard-coded array of five each.

#### Topics and Technologies Used

The main technologies used are objects and their associated arrays within the "AirField" class, which is where the meat and potatoes of the program reside. In version 1, there are three subclasses that extend the abstract class of "Jets": the "VanillaJet", the "FighterJet", and the "CargoPlane", with "FighterJet" implementing the "fight()" method from the "CombatReady" interface and "CargoPlane" implementing the "loadCargo()" method from the "CargoCarrier" interface. More to be added in later versions.

The backbone of the user interface is the menu system at the start, which is heavily reliant on loops throughout the program. Since there are a number of arrays with which to interact, foreach and regular loops were used to print out both regular Strings as well as StringBuilder objects as the given option is selected inside of the menu loop.

#### How to Run

Opening the program brings up a welcome message followed by a menu to allow for user interaction. Using the Scanner object, a choice may be made to interact with the program. The options listed provide the ability to call methods that can add to both pilot and plane arrays, list out those arrays, and even match a pilot to a plane.

It is, however, possible to have more pilots than planes or vice-versa. If this is the case, matching planes to pilots will result in only as many matches as there are the lesser of said planes or pilots. Without this protection in place, the program would attempt to match objects with a null value and upset the runtime environment.

Dog-fighting is not in the first version, but will be added as a stretch goal. Currently I am having loop issues!

#### Lessons Learned

Lessons in no particular order:

- It is much easier to access an array throughout a class if one keeps it as a non-static class. Cascades of annoyance flow forth if this is not followed. (Thank you, Denise, for the lesson and clarification on this particular bugbear!!)

- When iterating an array, it is good practice to provide a filter so that a given for or foreach loop does not have a "null-pointer exception" when it tries to act on an unfilled array.

- Many lessons to be learned about the dog fight. This stretch goal remains as such for now.
