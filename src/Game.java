public class Game {
    private String [] movieList;
    private String movie;
    private String secretTitle;
    private String guessedLetters;
    private int wrongLetters;


    public Game(String [] movieList){
        this.movieList = movieList;
    }

    public String getMovie() {
        return movie;
    }

    public void setMovie(String movie) {
        this.movie = movie;
    }

    public String getSecretTitle() {
        return secretTitle;
    }

    public void setSecretTitle(String secretTitle) {
        this.secretTitle = secretTitle;
    }

    public int getWrongLetters() {
        return wrongLetters;
    }

    public String getGuessedLetters() {
        return guessedLetters;
    }

    private int randomIndex(){
        return (int)(Math.random() * this.movieList.length);
    }

    private void makeDisplayString(){
        setSecretTitle(this.movie.replaceAll("[\\w']", "_"));
    }

    public void startNewGame(){
        int movieIndex = randomIndex();
        this.guessedLetters = "";
        this.wrongLetters = 0;
        this.setMovie(movieList[movieIndex]);
        System.out.println(getMovie());
        makeDisplayString();
    }

    public void guessLetter(String letter){
        String newTittle = "";
        if(!guessedLetters.contains(letter)){
            guessedLetters += letter;
        }

        if (this.getMovie().contains(letter)){
            newTittle = getMovie().replaceAll("[^ " + guessedLetters + "]", "_");
            setSecretTitle(newTittle);
        }
        else{
            wrongLetters++;
        }
    }

    public boolean hasWon(){
        if(getSecretTitle().equals(getMovie())){
            return true;
        }
        return false;
    }


}
