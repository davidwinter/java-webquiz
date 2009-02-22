# phpMyAdmin MySQL-Dump
# version 2.3.2
# http://www.phpmyadmin.net/ (download page)
#
# Host: localhost
# Generation Time: Apr 04, 2006 at 04:34 PM
# Server version: 3.23.58
# PHP Version: 3.0.18
# Database : `w0413500`
# --------------------------------------------------------

#
# Table structure for table `answers`
#

DROP TABLE IF EXISTS answers;
CREATE TABLE answers (
  id int(11) NOT NULL auto_increment,
  question_id int(11) NOT NULL default '0',
  answer text NOT NULL,
  correct tinyint(1) NOT NULL default '0',
  PRIMARY KEY  (id)
);

#
# Dumping data for table `answers`
#

INSERT INTO answers VALUES (1, 1, 'Goldfinger', '0');
INSERT INTO answers VALUES (2, 1, 'Dr. No', '1');
INSERT INTO answers VALUES (3, 1, 'Diamonds Are Forever', '0');
INSERT INTO answers VALUES (4, 2, 'Timothy Dalton', '0');
INSERT INTO answers VALUES (5, 2, 'Pierce Brosnan', '0');
INSERT INTO answers VALUES (6, 2, 'George Lazenby', '1');
INSERT INTO answers VALUES (7, 3, 'Per Fine Ounce', '0');
INSERT INTO answers VALUES (8, 3, 'Casino Royale', '1');
INSERT INTO answers VALUES (9, 3, 'Die Another Day', '0');
INSERT INTO answers VALUES (10, 4, 'Thunderball', '0');
INSERT INTO answers VALUES (11, 4, 'Goldfinger', '1');
INSERT INTO answers VALUES (12, 4, 'From Russia With Love', '0');
INSERT INTO answers VALUES (13, 5, 'Goldeneye', '1');
INSERT INTO answers VALUES (14, 5, 'From Russia With Love', '0');
INSERT INTO answers VALUES (15, 5, 'Tomorrow Never Dies', '0');
INSERT INTO answers VALUES (16, 6, 'Madonna', '1');
INSERT INTO answers VALUES (17, 6, 'Shirley Bassey', '0');
INSERT INTO answers VALUES (18, 6, 'Robbie Williams', '0');
INSERT INTO answers VALUES (19, 7, 'John Kitzmiller', '0');
INSERT INTO answers VALUES (20, 7, 'Yaphet Kotto', '1');
INSERT INTO answers VALUES (21, 7, 'Jack Lord', '0');
INSERT INTO answers VALUES (22, 8, 'Worldwide Exports Ltd', '0');
INSERT INTO answers VALUES (23, 8, 'Royal Exports', '0');
INSERT INTO answers VALUES (24, 8, 'Universal Exports', '1');
INSERT INTO answers VALUES (25, 9, 'Tomorrow Never Dies', '0');
INSERT INTO answers VALUES (26, 9, 'Live And Let Die', '1');
INSERT INTO answers VALUES (27, 9, 'The Living Daylights', '0');
INSERT INTO answers VALUES (28, 10, 'Timothy Dalton', '0');
INSERT INTO answers VALUES (29, 10, 'Geraint Griffiths', '0');
INSERT INTO answers VALUES (30, 10, 'Tom Jones', '1');
INSERT INTO answers VALUES (31, 11, 'The World Is Not Enough', '1');
INSERT INTO answers VALUES (32, 11, 'Octopussy', '0');
INSERT INTO answers VALUES (33, 11, 'The Man With The Golden Gun', '0');
INSERT INTO answers VALUES (34, 12, 'Goldfinger', '0');
INSERT INTO answers VALUES (35, 12, 'Scaramanga', '0');
INSERT INTO answers VALUES (36, 12, 'Dr No', '1');
INSERT INTO answers VALUES (37, 13, 'Licence To Kill', '1');
INSERT INTO answers VALUES (38, 13, 'Thunderball', '0');
INSERT INTO answers VALUES (39, 13, 'The Spy Who Loved Me', '0');
INSERT INTO answers VALUES (40, 14, 'Pen-knife', '0');
INSERT INTO answers VALUES (41, 14, 'An attache Case', '1');
INSERT INTO answers VALUES (42, 14, 'Aston Martin DB5', '0');
INSERT INTO answers VALUES (43, 15, '1950', '0');
INSERT INTO answers VALUES (44, 15, '1960', '1');
INSERT INTO answers VALUES (45, 15, '1970', '0');
INSERT INTO answers VALUES (46, 16, 'Tom Clancy', '0');
INSERT INTO answers VALUES (47, 16, 'John Gardner', '0');
INSERT INTO answers VALUES (48, 16, 'Ian Fleming', '1');
INSERT INTO answers VALUES (49, 17, 'Licence To Kill', '1');
INSERT INTO answers VALUES (50, 17, 'Moonraker', '0');
INSERT INTO answers VALUES (51, 17, 'On Her Majesty&rsquo;s Secret Service', '0');
INSERT INTO answers VALUES (52, 18, 'Istanbul, Turkey', '1');
INSERT INTO answers VALUES (53, 18, 'London, United Kingdom', '0');
INSERT INTO answers VALUES (54, 18, 'Paris, France', '0');
INSERT INTO answers VALUES (55, 19, 'The Spy Who Loved me', '0');
INSERT INTO answers VALUES (56, 19, 'For Your Eyes Only', '1');
INSERT INTO answers VALUES (57, 19, 'Goldeneye', '0');
INSERT INTO answers VALUES (58, 20, 'Q', '0');
INSERT INTO answers VALUES (59, 20, 'M', '1');
INSERT INTO answers VALUES (60, 20, 'Tanner', '0');
INSERT INTO answers VALUES (61, 21, 'Boris Grishenko', '0');
INSERT INTO answers VALUES (62, 21, 'Alec Trevelyan', '1');
INSERT INTO answers VALUES (63, 21, 'Dr No', '0');
# --------------------------------------------------------

#
# Table structure for table `highscores`
#

DROP TABLE IF EXISTS highscores;
CREATE TABLE highscores (
  id int(11) NOT NULL auto_increment,
  playername varchar(100) NOT NULL default '',
  highscore int(3) NOT NULL default '0',
  PRIMARY KEY  (id)
);

#
# Dumping data for table `highscores`
#

INSERT INTO highscores VALUES (1, 'James Bond', 100);
INSERT INTO highscores VALUES (2, 'Oddjob', 0);
INSERT INTO highscores VALUES (3, 'David Winter', 100);
INSERT INTO highscores VALUES (4, '007', 100);
# --------------------------------------------------------

#
# Table structure for table `questions`
#

DROP TABLE IF EXISTS questions;
CREATE TABLE questions (
  id int(11) NOT NULL auto_increment,
  question text NOT NULL,
  PRIMARY KEY  (id)
);

#
# Dumping data for table `questions`
#

INSERT INTO questions VALUES (1, 'What is the first Bond film that featured, Sean Connery?');
INSERT INTO questions VALUES (2, 'Which actor only appeared in one Bond film produced by, Eon Productions?');
INSERT INTO questions VALUES (3, 'What James Bond film is to be released on November 17, 2006?');
INSERT INTO questions VALUES (4, 'Which film did the following piece of dialog feature - &ldquo;Shocking. Positively shocking.&rdquo;');
INSERT INTO questions VALUES (5, 'Which James Bond game featured a level titled, &ldquo;Caverns&rdquo;?');
INSERT INTO questions VALUES (6, 'Who sang the theme song of &ldquo;Die Another Day&rdquo;?');
INSERT INTO questions VALUES (7, 'What &ldquo;Live And Let Die&rdquo; actor is in real life the song of a crown prince of Cameroon?');
INSERT INTO questions VALUES (8, 'In &ldquo;Licence To Kill&rdquo;, when he arrives at Krest&rsquo;s marine-research lab, for what company does Bond say he works?');
INSERT INTO questions VALUES (9, 'In which Bond film does the villain explode after swallowing a compressed-air capsule?');
INSERT INTO questions VALUES (10, 'What Welsh pop singer and sex symbol sang the title theme to &ldquo;Thunderball&rdquo;?');
INSERT INTO questions VALUES (11, 'In what film does the villain say to 007, &ldquo;You wouldn&rsquo;t kill me; you&rsquo;d miss me&rdquo;?');
INSERT INTO questions VALUES (12, 'What Bond villain has a $1 million window that looks out beneath the sea?');
INSERT INTO questions VALUES (13, 'What Bond film has a villain who dies when he is shot and pulled into an industrial pulveriser?');
INSERT INTO questions VALUES (14, 'What gadget does Q give to 007 in &ldquo;From Russia With Love&rdquo;?');
INSERT INTO questions VALUES (15, 'What decade released the most Bond films?');
INSERT INTO questions VALUES (16, 'What former naval-intellignce officer wrote the James Bond novels?');
INSERT INTO questions VALUES (17, 'What Bond film features the fictional country of Isthmus?');
INSERT INTO questions VALUES (18, '&ldquo;The World Is Not Enough&rdquo; involved a plot to set off a nuclear explosion in what city?');
INSERT INTO questions VALUES (19, 'Hector Gonzales is a Cuban hit man in what 007 film?');
INSERT INTO questions VALUES (20, 'Actor Bernard Lee played what character in the first eleven James Bond films?');
INSERT INTO questions VALUES (21, 'What 007 villain was angry about the 1945 betrayal  of the Lienz Cossacks by the British?');

