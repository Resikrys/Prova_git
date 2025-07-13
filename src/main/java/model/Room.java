package model;

public class Room {
        private String name;
        private int difficultyLevel;
        private double price;

        public Room(String name, int difficultyLevel, double price) {
            this.name = name;
            this.difficultyLevel = difficultyLevel;
            this.price = price;
        }

        // Getters
        public String getName() {
            return name;
        }

        public int getDifficultyLevel() {
            return difficultyLevel;
        }

        public double getPrice() {
            return price;
        }

        // Setters
        public void setName(String name) {
            this.name = name;
        }

        public void setDifficultyLevel(int difficultyLevel) {
            this.difficultyLevel = difficultyLevel;
        }

        public void setPrice(double price) {
            this.price = price;
        }

        @Override
        public String toString() {
            return "Room: " + name +
                    " | Difficulty: " + difficultyLevel +
                    " | Price: €" + price;
        }
    }

