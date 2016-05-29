Json2Java
=========

Swing GUI to automate the JSON To Java conversion.

<h3>What this tool can do right now:</h3>
Give it:
<ul>
<li>Class name to a json file</li>
<li>A package name for the classes it will generate</li>
<li>Json String</li>
<li>Output path</li>
<li>optionally, Use Array instead of list and use of wrapper class</li>
</ul>

Each class will have a default empty constructor.
The members of each class will follow Android naming conventions with an "m" prefix and camel case.
Each member will have a corresponding static final String that relates it to it's json counterpart 
Each member will have a @SerializedName annotation for very easy Gson parsing. (optional)
If a member called "mId" or "mUniqueId" is found, then equals and hashcode will be overridden so comparisons are made on the id.

<h3>What I want this tool to do in the future in no particular order</h3>
Special Thanks to jonfhancock, for giving me a head start https://github.com/jonfhancock/JsonToJava
