public enum Mode {
        BEGINNER(8, 8, 10),
        INTERMEDIATE(16, 16, 40),
        EXPERT(16, 30, 99);

        private int height;
        private int width;
        private int numofMines;

        /**
         * Constructor
         */

        Mode(int height, int width, int numofMines){
            this.height = height;
            this.width = width;
            this.numofMines = numofMines;
        }

        /**
         * Getters
         */

        public int getHeight() {
            return height;
        }

        public int getWidth() {
            return width;
        }

        public int getNumofMines() {
            return numofMines;
        }

        public int getNumofCells(){ return width * height;}
}
