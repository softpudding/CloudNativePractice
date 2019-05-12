CSS Coding Standards
=====================

 The followings are CSS Coding Standards which you must conform to when writing Cascading Style Sheets in CloudNatvePractice projects.<br>
 The purpose is to create a baseline for collaboration and review within various aspects of our project project, from core code to themes to plugins. Files within the project should appear as though created by a single entity. Above all else, create code that is readable, meaningful, consistent, and beautiful.

## Table of contents

 - [Structure](#Structure)
 - [Selectors](#Selectors)
 - [Properties](#Properties)
 - [Values](#Values)
 - [Media Queries](#Media-Queries)
 - [Commenting](#Commenting) 
 - [Tips for practicing above](#Tips-for-practicing-above)
 - [References](#References)
 
## Structure

It is important to retain a high degree of legibility, so:
- Use tabs, not spaces, to indent each property.
- Add two blank lines between sections and one blank line between blocks in a section.
- Each selector should be on its own line, ending in either a comma or an opening curly brace. 
- Property-value pairs should be on their own line, with one tab of indentation and an ending semicolon. 
- The closing brace should be flush left, using the same level of indentation as the opening selector.
 
Correct:
~~~css
#selector-1,
#selector-2,
#selector-3 {
  background-color: #dff0d8;
  border-color: #d6e9c6;
  color: #468847;
  -webkit-border-radius: 15px;
     -moz-border-radius: 15px;
          border-radius: 15px;
  font-weight: 700;
  margin: .5em 0;
  padding: .3em;
}
~~~
Incorrect：
~~~css
#selector-1, #selector-2, #selector-3 {
    background: #fff;
    color: #000;
    }
     
#selector-1 { background: #fff; color: #000; }
~~~

## Selectors

 - Use lowercase and separate words with hyphens when naming selectors. 
 - Avoid camelcase and underscores.
 - Use human readable selectors that describe what elements they style.
 - Attribute selectors should use double quotes around values
 - Refrain from using over-qualified selectors, div.container can simply be stated as .container
 
 Correct:
~~~css
 #comment-form {
     margin: 1em 0;
 }
  
 input[type="text"] {
     line-height: 1.1;
 }
~~~
 
 Incorrect:
 ~~~css
 #commentForm { /* Avoid camelcase. */
     margin: 0;
 } 
 #comment_form { /* Avoid underscores. */
     margin: 0;
 }
 div#comment_form { /* Avoid over-qualification. */
     margin: 0;
 } 
 #c1-xr { /* What is a c1-xr?! Use a better name. */
     margin: 0;
 } 
 input[type=text] { /* Should be [type="text"] */
     line-height: 110% /* Also doubly incorrect */
 }
~~~

## Properties

 - Properties should be followed by a colon and a space.
 - All properties and values should be lowercase, except for font names and vendor-specific properties.
 - Use hex code for colors, or rgba() if opacity is needed. Avoid RGB format and uppercase, and shorten values when possible: #fff instead of #FFFFFF.

Correct
~~~css
#selector-1 {
    background: #fff;
    display: block;
    margin: 0;
    margin-left: 20px;
}
~~~
Incorrect
~~~css
#selector-1 {
    background:#FFFFFF;
    display: BLOCK;
    margin-left: 20PX;
    margin: 0;
}
~~~

## Values

 - Space before the value, after the colon.
 - Do not pad parentheses with spaces.
 - Always end in a semicolon.
 - Use double quotes rather than single quotes, and only when needed, such as when a font name has a space or for the values of the content property.
 - Font weights should be defined using numeric values 
 - Lists of values within a value, like within rgba(), should be separated by a space

Correct
~~~css
.class { /* Correct usage of zero values */
    font-family: Georgia, serif;
    line-height: 1.4;
    text-shadow:
        0 -1px 0 rgba(0, 0, 0, 0.5),
        0 1px 0 #fff;
}
 
.class { /* Correct usage of short and lengthier multi-part values */
    font-family: Consolas, Monaco, monospace;
    transition-property: opacity, background, color;
    box-shadow:
        0 0 0 1px #5b9dd9,
        0 0 2px 1px rgba(30, 140, 190, 0.8);
}
~~~
Incorrect
~~~css
.class {
    font-family: Times New Roman, serif; /* Quote font names when required */
    font-weight: bold; /* Avoid named font weights */
    line-height: 1.4em;
}
 
.class { /* Incorrect usage of multi-part values */
    text-shadow: 0 1px 0 rgba(0, 0, 0, 0.5),
                 0 1px 0 #fff;
    box-shadow: 0 1px 0 rgba(0, 0,
        0, 0.5),
        0 1px 0 rgba(0,0,0,0.5);
}
~~~

## Media Queries

 - keep media queries grouped by media at the bottom of the stylesheet.
 - Rule sets for media queries should be indented one level in.
 
 Sample
 ~~~css
 @media all and (max-width: 699px) and (min-width: 520px) {
  
         /* Your selectors */
 }
 ~~~

## Commenting

 - Section/subsection headers should have newlines before and after. 
 - Inline comments should not have empty newlines separating the comment from the item to which it relates.

For sections and subsections:
~~~css
/*
 * #.# Section title
 *
 * Description of section, whether or not it has media queries, etc.
 */

.selector {
    float: left;
}
~~~
For inline:
~~~css
/* This is a comment about this selector */
.another-selector {
    position: absolute;
    top: 0 !important; /* I should explain why this is so !important */
}
~~~

## Tips for practicing above

Stylesheets tend to get long in length. Focus slowly gets lost whilst intended goals start repeating and overlapping. Writing smart code from the outset helps us retain the overview whilst remaining flexible throughout change.

## References

This file is finished with the help of:
 - [CSS Coding Standards](https://make.wordpress.org/core/handbook/best-practices/coding-standards/css/#values)
 - [bjankord/CSS-Coding-Standards](https://github.com/bjankord/CSS-Coding-Standards)
