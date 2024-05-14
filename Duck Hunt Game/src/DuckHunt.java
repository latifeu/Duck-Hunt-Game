import javafx.animation.Animation;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.animation.AnimationTimer;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.*;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.animation.FadeTransition;
import javafx.scene.input.KeyCode;

import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;


public class DuckHunt extends Application {

    @Override
    public void start(Stage primaryStage) {


        primaryStage.setTitle("HUBMM Duck Hunt");
        primaryStage.getIcons().add(new Image("assets/favicon/1.png"));
        // Load the background image
        Image backgroundImage = new Image("assets/welcome/1.png");
        Image gameBackground1 = new Image("assets/background/1.png");
        Image gameBackground2 = new Image("assets/background/2.png");
        Image gameBackground3 = new Image("assets/background/3.png");
        Image gameBackground4 = new Image("assets/background/4.png");
        Image gameBackground5= new Image("assets/background/5.png");
        Image gameBackground6= new Image("assets/background/6.png");
        Image foreGround= new Image("assets/foreground/1.png");
        Image foreGround2= new Image("assets/foreground/2.png");
        Image foreGround3= new Image("assets/foreground/3.png");
        Image foreGround4= new Image("assets/foreground/4.png");
        Image foreGround5= new Image("assets/foreground/5.png");
        Image foreGround6= new Image("assets/foreground/6.png");
        Image crossHair1 = new Image("assets/crosshair/1.png");
        Image crossHair2 = new Image("assets/crosshair/2.png");
        Image crossHair3 = new Image("assets/crosshair/3.png");
        Image crossHair4 = new Image("assets/crosshair/4.png");
        Image crossHair5 = new Image("assets/crosshair/5.png");
        Image crossHair6 = new Image("assets/crosshair/6.png");
        Image crossHair7 = new Image("assets/crosshair/7.png");
        ArrayList<Image> imageList = new ArrayList<>();
        ArrayList<Image> crosshairList = new ArrayList<>();
        ArrayList<Image> foreGroundList = new ArrayList<>();
        foreGroundList.add(foreGround);
        foreGroundList.add(foreGround2);
        foreGroundList.add(foreGround3);
        foreGroundList.add(foreGround4);
        foreGroundList.add(foreGround5);
        foreGroundList.add(foreGround6);
        imageList.add(gameBackground1);
        imageList.add(gameBackground2);
        imageList.add(gameBackground3);
        imageList.add(gameBackground4);
        imageList.add(gameBackground5);
        imageList.add(gameBackground6);
        crosshairList.add(crossHair1);
        crosshairList.add(crossHair2);
        crosshairList.add(crossHair3);
        crosshairList.add(crossHair4);
        crosshairList.add(crossHair5);
        crosshairList.add(crossHair6);
        crosshairList.add(crossHair7);
        final boolean[] isItCrushed = {false};
        final boolean[] isItChoose = {false};


        final Pane layout = new StackPane(); // create layout

        // The texts to be used later have been generated.
        final Text text = new Text(" \n \n \n \n  \n PRESS ENTER TO START \n    PRESS ESC TO EXİT");
        text.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        text.setFill(Color.ORANGE);
        text.setOpacity(0);
        final Text textWin = new Text("");
        textWin.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        textWin.setFill(Color.ORANGE);
        textWin.setOpacity(1);
        final Text textWinFlash = new Text("");
        textWinFlash.setFont(Font.font("Arial", FontWeight.BOLD, 25));
        textWinFlash.setFill(Color.ORANGE);
        textWinFlash.setOpacity(0);

        // Create a fade transition to make the text fade in and out
        FadeTransition fadeTransition = new FadeTransition(Duration.seconds(1), text);
        fadeTransition.setFromValue(0);
        fadeTransition.setToValue(1);
        fadeTransition.setCycleCount(FadeTransition.INDEFINITE);
        fadeTransition.setAutoReverse(true);



        //set the background image
        BackgroundImage backgroundImg = new BackgroundImage(
                backgroundImage,
                BackgroundRepeat.NO_REPEAT,
                BackgroundRepeat.NO_REPEAT,
                BackgroundPosition.DEFAULT,
                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

        //create an imageview object for crosshair
        ImageView crosshairImageView = new ImageView();
        ImageView imageView = new ImageView();
        fadeTransition.play();
        final AtomicInteger[] counter = {new AtomicInteger()};

        // Create a scene with the layout pane
        Scene scene = new Scene(layout, 500, 500);
        scene.setOnKeyPressed(event -> {

            AtomicInteger counterRL= new AtomicInteger();
            AtomicInteger counterUD= new AtomicInteger();
            if (event.getCode() == KeyCode.ENTER) {
                Image pngImage = new Image("assets/crosshair/1.png");
                // Set initial foreground image
                imageView.setImage(foreGroundList.get(0));
                imageView.setFitHeight(500);// Set size for foreground image view
                imageView.setFitWidth(500);
                // Set up crosshair image and size
                crosshairImageView.setImage(pngImage);
                crosshairImageView.setFitWidth(20);
                crosshairImageView.setFitHeight(20);
                text.setText(" USE ARROW KEYS TO NAVİGATE \n       PRESS ENTER TO START  \n            PRESS ESC TO EXIT     \n \n \n  \n  \n \n \n \n  \n \n \n  \n");
                text.setOpacity(1);
                textWin.setFont(Font.font("Arial", FontWeight.BOLD, 18));
                text.toFront();
                fadeTransition.setCycleCount(0);
                BackgroundImage gameBack = new BackgroundImage(
                        gameBackground1,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundRepeat.NO_REPEAT,
                        BackgroundPosition.DEFAULT,
                        new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

                scene.setOnKeyPressed(event2 -> {
                    //Clear the text displayed on the screen.
                    text.setText("");
                    //Check if the right arrow key is pressed.
                    if(event2.getCode() == KeyCode.RIGHT){
                        if (counterRL.get()==4 ){
                            counterRL.set(0);
                        }
                        counterRL.addAndGet(1);
                        //Create a new BackgroundImage object with the updated image
                        // from imageList based on the current value of counterRL, specifying the background repeat, position, and size.
                        BackgroundImage newBackground = new BackgroundImage(
                                imageList.get(counterRL.get()),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));

                        layout.setBackground(new Background(newBackground));
                        textWinFlash.toFront();
                        imageView.toFront();
                        crosshairImageView.toFront();
                        //Set the image of the imageView to the foreground image from foreGroundList based on the current value of counterRL.
                        imageView.setImage(foreGroundList.get(counterRL.get()));
                        imageView.setFitHeight(500);
                        imageView.setFitWidth(500);
                        imageView.toFront();
                        crosshairImageView.toFront();
                        isItChoose[0]=true;

                    }
                    else if(event2.getCode() == KeyCode.LEFT){
                        if ( counterRL.get()<=0){
                            counterRL.set(4);
                        }
                        counterRL.addAndGet(-1);
                        //Create a new BackgroundImage object using the image from imageList
                        // at the updated counterRL index, specifying the desired background repeat, position, and size.
                        BackgroundImage newBackground = new BackgroundImage(
                                imageList.get(counterRL.get()),
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundRepeat.NO_REPEAT,
                                BackgroundPosition.DEFAULT,
                                new BackgroundSize(BackgroundSize.AUTO, BackgroundSize.AUTO, false, false, true, false));
                        layout.setBackground(new Background(newBackground));
                        textWinFlash.toFront();
                        imageView.toFront();
                        crosshairImageView.toFront();
                        //Set the image of the imageView to the foreground image from foreGroundList at the updated counterRL index.
                        imageView.setImage(foreGroundList.get(counterRL.get()));
                        imageView.setFitHeight(500);
                        imageView.setFitWidth(500);
                        imageView.toFront();
                        crosshairImageView.toFront();

                        isItChoose[0]=true;



                    }
                    else if(event2.getCode() == KeyCode.UP){
                        if (counterUD.get()==6 ){
                            counterUD.set(0);
                        }
                        counterUD.addAndGet(1);
                        //Set the image of the crosshairImageView to the crosshair image from crosshairList using the updated value of counterUD.
                        crosshairImageView.setImage(crosshairList.get(counterUD.get()));

                    }
                    else if(event2.getCode() == KeyCode.DOWN){
                        if (counterUD.get()==0 ){
                            counterUD.set(6);
                        }
                        counterUD.addAndGet(-1);
                        //Set the image of the crosshairImageView to the crosshair image from crosshairList using the updated value of counterUD.
                        crosshairImageView.setImage(crosshairList.get(counterUD.get()));

                    }
                    if(event2.getCode() == KeyCode.ENTER){
                        counter[0].addAndGet(1);
                        if (counter[0].get()==1){//LEVEL1
                            textWin.setText("");
                            textWinFlash.setText("");
                            AtomicInteger hitPoint= new AtomicInteger(3);
                            text.setText("                                               Level "+ counter[0].get()+"/6                               Ammo Left "+hitPoint.get()  +"\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");                            text.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                            layout.setOnMouseMoved((MouseEvent event5) -> {
                                // Removed update of crosshairImageView as mouse moves
                                crosshairImageView.setTranslateY(event5.getSceneY() -250);
                                crosshairImageView.setTranslateX(event5.getSceneX() -250);
                            });
                            Image duckImage2 = new Image("assets/duck_black/4.png");
                            Image duckImage1 = new Image("assets/duck_black/6.png");
                            Image duckImage3 = new Image("assets/duck_black/5.png");
                            Image fallImage = new Image("assets/duck_black/7.png");
                            Image downImage = new Image("assets/duck_black/8.png");

                            ImageView movingImageView = new ImageView(duckImage1);
                            movingImageView.setFitWidth(60); // Genişlik ayarı
                            movingImageView.setFitHeight(60); // Yükseklik ayarı
                            movingImageView.setTranslateY(-170);
                            movingImageView.toBack();

                            //  create TranslateTransition for flying duck animation
                            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(5), movingImageView);
                            translateTransition.setFromX(-220);
                            translateTransition.setToX(220);
                            translateTransition.setCycleCount(Animation.INDEFINITE);
                            translateTransition.setAutoReverse(true);
                            translateTransition.setRate(1.75); // Decrease speed (slow down)
                            layout.getChildren().add(movingImageView);
                            imageView.toFront();
                            textWin.toFront();
                            textWinFlash.toFront();
                            long startTime = System.nanoTime();
                            TranslateTransition yTransition = new TranslateTransition(Duration.seconds(3), movingImageView);
                            yTransition.setFromY(-170);
                            yTransition.setToY(250); // sliding about the y axis
                            //Create a new AnimationTimer named timer with an overridden handle method.
                            AnimationTimer timer = new AnimationTimer() {

                                @Override
                                public void handle(long now) {
                                    //Else if the movingImageView is within a different range of X translation values
                                    // (between -215 and -250), set the X scale of the movingImageView to 1, restoring its original orientation.

                                    if(movingImageView.getTranslateX()>215 & movingImageView.getTranslateX()<250){
                                        movingImageView.setScaleX(-1);

                                    }else if(movingImageView.getTranslateX()<-215 & movingImageView.getTranslateX()>-250){
                                        movingImageView.setScaleX(1);

                                    }
                                    //Calculate the elapsed time since the startTime using the now parameter.
                                    //Convert the elapsed time to seconds by dividing it by 1,000,000,000.
                                    long elapsedTime = now - startTime;
                                    double newSecond = elapsedTime / 1_000_000_000.0; // Geçen zamanı saniyeye çevirme
                                    // Geçen sürenin çift veya tek olduğunu kontrol etme
                                    if(!isItCrushed[0]){
                                        //If the elapsed time is an even number, set the image of the movingImageView to duckImage2.
                                        //If the elapsed time is a multiple of 5 or 10, set the image of the movingImageView to duckImage3.
                                        //Otherwise, set the image of the movingImageView to duckImage1.
                                        if (newSecond==0 ){
                                            movingImageView.setImage(duckImage1);
                                        }
                                        else if((int) newSecond % 2 == 0  ){
                                            movingImageView.setImage(duckImage2); // İkinci fotoğrafı göster
                                        }
                                        else if((int) newSecond % 5== 0 || (int) newSecond  % 10== 0 ){
                                            movingImageView.setImage(duckImage3); // İkinci fotoğrafı göster
                                        }

                                        else {
                                            movingImageView.setImage(duckImage1); // İlk fotoğrafı göster
                                        }
                                    }

                                    layout.setOnMouseClicked(event -> {
                                        //The code sets a mouse click event listener on a layout.
                                        hitPoint.addAndGet(-1);
                                        if(crosshairImageView.getTranslateX()<movingImageView.getTranslateX()+30 & movingImageView.getTranslateX()-30<crosshairImageView.getTranslateX()){
                                            if(crosshairImageView.getTranslateY()<movingImageView.getTranslateY()+30 & movingImageView.getTranslateY()-30<crosshairImageView.getTranslateY()){
                                                //When the layout is clicked, it decreases a hit point value and checks for overlapping image views.
                                                isItCrushed[0] =true;
                                                if (hitPoint.get()>0){
                                                    text.setText("                                                  Level 1/6                                Ammo Left "+hitPoint.get()+ "\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");
                                                    textWin.setFont(Font.font("Arial", FontWeight.BOLD, 25));
                                                    //If the views overlap, a variable is set to true and a victory message is displayed.
                                                    textWin.setText("YOU WIN! \n \n  \n ");
                                                    textWin.setFont(Font.font("Arial", FontWeight.BOLD, 25));

                                                    textWin.toFront();
                                                    //The code also animates a flashing text and updates the image and animation of another view.
                                                    textWinFlash.setText("Press ENTER to play next level  \n");
                                                    FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1), textWinFlash);
                                                    fadeTransition2.setFromValue(0);
                                                    fadeTransition2.setToValue(1);
                                                    fadeTransition2.setCycleCount(FadeTransition.INDEFINITE);
                                                    fadeTransition2.setAutoReverse(true);
                                                    fadeTransition2.play();
                                                    if(movingImageView.getScaleX()==-1){
                                                        //it turns the direction of the bird, determines the direction of the bird as it falls,
                                                        // according to the direction it turns
                                                        movingImageView.setImage(fallImage);
                                                        translateTransition.stop();
                                                        movingImageView.setImage(downImage);
                                                        movingImageView.setScaleX(1);
                                                    }else{
                                                        movingImageView.setImage(fallImage);
                                                        translateTransition.stop();
                                                        movingImageView.setImage(downImage);
                                                        movingImageView.setScaleX(-1);
                                                    }
                                                    yTransition.play();
                                                }else if (hitPoint.get()==0){
                                                    //If the value of hitPoint is 0, it updates the victory message and displays it.
                                                    textWin.setText("YOU WIN! \n \n  \n \n ");
                                                    textWin.setFont(Font.font("Arial", FontWeight.BOLD, 25));
                                                    textWin.toFront();
                                                    textWinFlash.setText("Press ENTER to play next level  \n");
                                                    //It sets up a flashing text and animates it using a FadeTransition effect.
                                                    FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1), textWinFlash);
                                                    fadeTransition2.setFromValue(0);
                                                    fadeTransition2.setToValue(1);
                                                    fadeTransition2.setCycleCount(FadeTransition.INDEFINITE);
                                                    fadeTransition2.setAutoReverse(true);
                                                    fadeTransition2.play();
                                                    if(movingImageView.getScaleX()==-1){
                                                        //it turns the direction of the bird, determines the direction of the bird as it falls,
                                                        // according to the direction it turns
                                                        movingImageView.setImage(fallImage);
                                                        translateTransition.stop();
                                                        movingImageView.setImage(downImage);
                                                        movingImageView.setScaleX(1);
                                                    }else{
                                                        movingImageView.setImage(fallImage);
                                                        translateTransition.stop();
                                                        movingImageView.setImage(downImage);
                                                        movingImageView.setScaleX(-1);
                                                    }
                                                    yTransition.play();
                                                    text.setText("                                                  Level 1/6                                Ammo Left 0 \n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");

                                                    hitPoint.addAndGet(1);
                                                }

                                            }else{
                                                if(hitPoint.get()==0){
                                                    //If the value of hitPoint is 0, it decreases a counter, updates the text component
                                                    // with a game over message and information, and displays a game over message with options to play again or exit.
                                                    counter[0].addAndGet(-1);
                                                    text.setText("                                                  Level 1/6                                Ammo Left " +hitPoint.get()+
                                                            "\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");
                                                    textWin.setText("GAME OVER! \n \n  \n ");
                                                    textWin.setFont(Font.font("Arial", FontWeight.BOLD, 25));
                                                    textWin.toFront();
                                                    textWinFlash.setText("   Press ENTER to play again  \n          Press ESC to exit     " );
                                                    FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1), textWinFlash);
                                                    fadeTransition2.setFromValue(0);
                                                    fadeTransition2.setToValue(1);
                                                    fadeTransition2.setCycleCount(FadeTransition.INDEFINITE);
                                                    fadeTransition2.setAutoReverse(true);
                                                    fadeTransition2.play();
                                                    movingImageView.setVisible(false);
                                                }else if (hitPoint.get()>0)
                                                //If the value of hitPoint is greater than 0, it updates the text component with level and ammo information.
                                                {
                                                    text.setText("                                               Level "+ counter[0].get()+"/6                               Ammo Left "+hitPoint.get()  +"\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");

                                                }
                                            }

                                        }else{
                                            if(hitPoint.get()==0){
                                                //If the value of hitPoint is 0, it decreases a counter,
                                                // updates the text component with level and ammo information, and displays a game over message.
                                                counter[0].addAndGet(-1);
                                                text.setText("                                                  Level 1/6                                Ammo Left " +hitPoint.get()+
                                                        "\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");
                                                textWin.setText("GAME OVER! \n \n  \n ");
                                                textWin.setFont(Font.font("Arial", FontWeight.BOLD, 25));
                                                textWin.toFront();
                                                textWinFlash.setText("   Press ENTER to play again  \n          Press ESC to exit     " );
                                                //It sets up a flashing text and animates it using a FadeTransition effect.
                                                //The movingImageView becomes invisible.
                                                FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1), textWinFlash);
                                                fadeTransition2.setFromValue(0);
                                                fadeTransition2.setToValue(1);
                                                fadeTransition2.setCycleCount(FadeTransition.INDEFINITE);
                                                fadeTransition2.setAutoReverse(true);
                                                fadeTransition2.play();
                                                movingImageView.setVisible(false);
                                            }else if (hitPoint.get()>0)
                                            {
                                                text.setText("                                               Level "+ counter[0].get()+"/6                               Ammo Left "+hitPoint.get()  +"\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");

                                            }
                                        }


                                    });

                                }
                            };
                            timer.start();

                            //The timer is started.
                            //The crosshairImageView is brought to the front.
                            //The movingImageView is sent to the back.
                            crosshairImageView.toFront();
                            movingImageView.toBack();
                            translateTransition.play();
                        }
                        //second level of game
                        if(counter[0].get()==2){
                            textWin.setText("");
                            textWinFlash.setText("");
                            final boolean[] isItDead = {false};
                            final boolean[] isItCrushed2 = {false};
                            AtomicInteger hitPoint2= new AtomicInteger(3);
                            text.setText("                                               Level "+ counter[0].get()+"/6                               Ammo Left "+hitPoint2.get()  +"\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");                            text.setFont(Font.font("Arial", FontWeight.BOLD, 15));
                            layout.setOnMouseMoved((MouseEvent event5) -> {
                                // Fare hareket ettikçe crosshairImageView'ın konumunu güncelleme
                                crosshairImageView.setTranslateY(event5.getSceneY() -250);
                                crosshairImageView.setTranslateX(event5.getSceneX() -250);
                            });
                            Image duckImage1 = new Image("assets/duck_blue/1.png");
                            Image duckImage2 = new Image("assets/duck_blue/2.png");
                            Image duckImage3 = new Image("assets/duck_blue/3.png");
                            ImageView movingImageView = new ImageView(duckImage1);
                            movingImageView.setX(230);


                            movingImageView.setFitWidth(60);
                            movingImageView.setFitHeight(60);
                            movingImageView.toBack();


                            //A TranslateTransition named translateTransition is created with a duration of 5 seconds and applied to the movingImageView.
                            TranslateTransition translateTransition = new TranslateTransition(Duration.seconds(5), movingImageView);
                            //The starting X and Y positions for the translation animation are set to (-220, 0).
                            //The ending X and Y positions for the translation animation are set to (0, -220).
                            translateTransition.setFromX(-220);
                            translateTransition.setFromY(0);
                            translateTransition.setToX(0);
                            translateTransition.setToY(-220);
                            translateTransition.setCycleCount(Animation.INDEFINITE);
                            translateTransition.setAutoReverse(false);
                            translateTransition.setRate(1.75); // Hızı azaltma (yavaşla
                            layout.getChildren().add(movingImageView);
                            movingImageView.toBack();
                            imageView.toFront();

                            textWin.toFront();
                            textWinFlash.toFront();
                            TranslateTransition yTransition = new TranslateTransition(Duration.seconds(2), movingImageView);

                            long startTime = System.nanoTime();
                            AnimationTimer timer = new AnimationTimer() {
                                @Override
                                public void handle(long now) {
                                    long elapsedTime = now - startTime;
                                    double newSecond = elapsedTime / 1_000_000_000.0; // Convert elapsed time to seconds

                                    if(!isItCrushed2[0]){
                                        if (newSecond==0 ){
                                            movingImageView.setImage(duckImage1);
                                        }
                                        else if((int) newSecond % 2 == 0  ){
                                            movingImageView.setImage(duckImage2); // show the second photo
                                        }
                                        else if((int) newSecond % 3== 0 || (int) newSecond  % 6== 0 ){
                                            movingImageView.setImage(duckImage3); // show the third photo
                                        }

                                        else {
                                            movingImageView.setImage(duckImage1); // show the first photo
                                        }
                                    }

                                    if(movingImageView.getTranslateY()<-219 & !isItCrushed2[0]){
                                        //It checks if the image hits the wall, and if it hits the wall, it reflects it at the angle it came from.
                                        movingImageView.setScaleY(-1);
                                        translateTransition.setRate(1.75);
                                        translateTransition.setFromX(movingImageView.getTranslateX());
                                        translateTransition.setToX(220);
                                        translateTransition.setFromY(movingImageView.getTranslateY());
                                        translateTransition.setToY(0);
                                        translateTransition.playFromStart();
                                    }
                                    else if(movingImageView.getTranslateX()>219 & !isItCrushed2[0]){
                                        //It checks if the image hits the wall, and if it hits the wall, it reflects it at the angle it came from.
                                        movingImageView.setScaleX(-1);

                                        translateTransition.setRate(1.75);
                                        translateTransition.setFromX(movingImageView.getTranslateX());
                                        translateTransition.setToX(0);
                                        translateTransition.setFromY(movingImageView.getTranslateY());
                                        translateTransition.setToY(220);
                                        translateTransition.playFromStart();
                                    }
                                    else if(movingImageView.getTranslateY()>219& !isItCrushed2[0]){
                                        //It checks if the image hits the wall, and if it hits the wall, it reflects it at the angle it came from.
                                        movingImageView.setScaleY(1);

                                        translateTransition.setRate(1.75);
                                        translateTransition.setFromX(movingImageView.getTranslateX());
                                        translateTransition.setToX(-221);
                                        translateTransition.setFromY(movingImageView.getTranslateY());
                                        translateTransition.setToY(0);
                                        translateTransition.playFromStart();
                                    }
                                    else if(movingImageView.getTranslateX()<-220& !isItCrushed2[0]){
                                        //It checks if the image hits the wall, and if it hits the wall, it reflects it at the angle it came from.
                                        movingImageView.setScaleX(1);

                                        translateTransition.setRate(1.75);
                                        translateTransition.setFromX(movingImageView.getTranslateX());
                                        translateTransition.setToX(0);
                                        translateTransition.setFromY(movingImageView.getTranslateY());
                                        translateTransition.setToY(-220);
                                        translateTransition.playFromStart();
                                    }
                                    layout.setOnMouseClicked(event -> {
                                        Image fallImage=new Image("assets/duck_blue/7.png");
                                        Image downImage=new Image("assets/duck_blue/8.png");
                                        hitPoint2.addAndGet(-1);

                                        if(crosshairImageView.getTranslateX()<movingImageView.getTranslateX()+30 & movingImageView.getTranslateX()-30<crosshairImageView.getTranslateX()){
                                            if(crosshairImageView.getTranslateY()<movingImageView.getTranslateY()+30 & movingImageView.getTranslateY()-30<crosshairImageView.getTranslateY()){
                                                isItCrushed2[0] =true;
                                                if (hitPoint2.get()>0){
                                                    text.setText("                                                  Level 2/6                                Ammo Left "+hitPoint2.get()+ "\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");

                                                    textWin.setText("YOU WIN! \n \n  \n ");
                                                    textWin.toFront();
                                                    textWinFlash.setText("Press ENTER to play next level  \n");
                                                    FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1), textWinFlash);
                                                    fadeTransition2.setFromValue(0);
                                                    fadeTransition2.setToValue(1);
                                                    fadeTransition2.setCycleCount(FadeTransition.INDEFINITE);
                                                    fadeTransition2.setAutoReverse(true);
                                                    fadeTransition2.play();

                                                    if(movingImageView.getScaleX()==-1){
                                                        movingImageView.setImage(fallImage);
                                                        yTransition.setFromY(movingImageView.getTranslateY());
                                                        yTransition.setToY(220);
                                                        translateTransition.stop();
                                                        movingImageView.setImage(downImage);
                                                        movingImageView.setScaleX(1);

                                                    }else{
                                                        movingImageView.setImage(fallImage);
                                                        yTransition.setFromY(movingImageView.getTranslateY());
                                                        yTransition.setToY(220);
                                                        translateTransition.stop();
                                                        movingImageView.setImage(downImage);
                                                        movingImageView.setScaleX(-1);
                                                    }
                                                    yTransition.play();
                                                }
                                                //This part checks whether the game is over as in the first round and shows you won or game over accordingly.
                                                else if(hitPoint2.get()==0){
                                                    textWin.setText("YOU WIN! \n \n  \n ");
                                                    textWin.toFront();
                                                    textWinFlash.setText("Press ENTER to play next level  \n");
                                                    FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1), textWinFlash);
                                                    fadeTransition2.setFromValue(0);
                                                    fadeTransition2.setToValue(1);
                                                    fadeTransition2.setCycleCount(FadeTransition.INDEFINITE);
                                                    fadeTransition2.setAutoReverse(true);
                                                    fadeTransition2.play();

                                                    if(movingImageView.getScaleX()==-1){
                                                        movingImageView.setImage(fallImage);
                                                        yTransition.setFromY(movingImageView.getTranslateY());
                                                        yTransition.setToY(220);
                                                        translateTransition.stop();
                                                        movingImageView.setImage(downImage);
                                                        movingImageView.setScaleX(1);

                                                    }else{
                                                        movingImageView.setImage(fallImage);
                                                        yTransition.setFromY(movingImageView.getTranslateY());
                                                        yTransition.setToY(220);
                                                        translateTransition.stop();
                                                        movingImageView.setImage(downImage);
                                                        movingImageView.setScaleX(-1);
                                                    }
                                                    yTransition.play();
                                                    text.setText("                                                  Level 2/6                                Ammo Left 0 \n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");

                                                    hitPoint2.addAndGet(+1);
                                                }

                                            }
                                        }
                                        else{
                                            if(hitPoint2.get()==0){
                                                counter[0].addAndGet(-1);
                                                text.setText("                                                  Level 2/6                                Ammo Left "+hitPoint2.get()  +"\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");
                                                textWin.setText("GAME OVER! \n \n  \n ");
                                                textWin.setFont(Font.font("Arial", FontWeight.BOLD, 25));
                                                textWin.toFront();
                                                textWinFlash.setText("   Press ENTER to play again  \n          Press ESC to exit     " );
                                                FadeTransition fadeTransition2 = new FadeTransition(Duration.seconds(1), textWinFlash);
                                                fadeTransition2.setFromValue(0);
                                                fadeTransition2.setToValue(1);
                                                fadeTransition2.setCycleCount(FadeTransition.INDEFINITE);
                                                fadeTransition2.setAutoReverse(true);
                                                fadeTransition2.play();
                                                movingImageView.setVisible(false);
                                            }else{
                                                text.setText("                                               Level "+ counter[0].get()+"/6                               Ammo Left "+hitPoint2.get()  +"\n \n \n \n  \n  \n \n \n \n \n \n  \n  \n \n \n \n  \n \n \n  \n\n \n \n \n  \n  \n \n");
                                            }



                                        }

                                    });


                                }
                            };
                            //The timer and translation animation are started.
                            timer.start();
                            translateTransition.play();

                        }

                    }
                });
                //The background of the layout is set to gameBack.
                layout.setBackground(new Background(gameBack));
                fadeTransition.stop(); // Yanıp sönme animasyonunu durdur


                //If the pressed key is ESCAPE, the primary stage (window) is closed.
            }else if (event.getCode() == KeyCode.ESCAPE) {
                primaryStage.close();
            }

        });
        //The crosshairImageView, text, imageView, textWin, and textWinFlash components are added to the layout.

        textWin.toFront();
        textWinFlash.toFront();
        crosshairImageView.toFront();
        layout.setBackground(new Background(backgroundImg));
        layout.getChildren().addAll(crosshairImageView,text,imageView,textWin,textWinFlash);

        // Set the scene on the primary stage
        primaryStage.setScene(scene);

        // Show the window
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}
