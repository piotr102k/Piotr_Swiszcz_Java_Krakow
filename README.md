# Basket Splitter

A program that splits recievied items into the most optimal way of delivering them.

# Instalation

1. Clone the repository
2. Build the project using Maven
3. Run the projec

# How to use

1. Create a BasketSplitter class by giving it a absolute path to CONFIG.JSON (a JSON file containing all items with their delivery methods).
2. Use the .split() function with a List<String> parameter containing a list of all of your products.
3. The function returns a Map<String,List<String>> with your items split into delivery methods.
