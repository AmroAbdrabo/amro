<div align="center">
<b>Team Members: </b>

Amro Abdrabo [amro.abdrabo@gmail.com | [LinkedIn](https://www.linkedin.com/in/amroabdrabo/)]

Shiyi Li  [shiyi.li@ifu.baug.ethz.ch | [LinkedIn](www.linkedin.com/in/shiyili01)]

Thomas Radinger [ thomasrad@protonmail.com | [LinkedIn](https://www.linkedin.com/in/thomas-radinger-743958142/) ]
</div>

# Introduction 

Birds are key indicators of ecosystem health and play pivotal roles in maintaining biodiversity [1]. To monitor and protect bird species, automatic bird sound recognition systems are essential. These systems can help in identifying bird species, monitoring their populations, and understanding their behavior. However, building such systems is challenging due to the diversity of bird sounds, complex acoustic interference and limited labeled data. 

To tackle these challenges, we expored the potential of deep learning models for bird sound recognition. In our work, we developed two Audio Spectrogram Transformer (AST) based models: BirdAST and BirdAST_Seq, to predict bird species from audio recordings. We evaluated the models on a dataset of 728 bird species and achieved promising results.  Details of the models and evaluation results are provided in the table below. As the field-recordings may contain various types of audio rather than only bird songs/calls, we also employed an Audio Masked AutoEncoder (AudioMAE) model to pre-classify audio clips into bird, insects, rain, environmental noise, and other types [2]. For a full report on work workflow and results, please refer to [link](https://docs.google.com/document/d/17uRGEVz4hxShK4fvWQzIKFJlVwEg9p1rAT9XXDYGE3w/edit?usp=sharing).

Our contributions have shown the potential of deep learning models for bird sound recognition. We hope that our work can contribute to the development of automatic bird sound recognition systems and help in monitoring and protecting bird species.

<div align="center">
<b>Model Details</b>

| Model name       | Architecture                   | ROC-AUC Score |
| ---------------  |:------------------------------:|:-------------:|
| BirdAST          | AST* + MLP                     | 0.6825        |
| BirdAST_Seq      | AST* + Sequence Pooling + MLP  | 0.7335        |
| BirdWav2Vec      | Wav2Vec* (Pretrained)          | 0.8051        |

</div>

# How to use the space:

1. Choose a model from the dropdown list. It will download the model weights automatically if not already downloaded (~30 seconds).
2. Upload an audio clip and specify the start and end time for prediction. 
3. Click on the "Predict" button to get the predictions.
4. In the output, you will get the audio type classification (e.g., bird, insects, rain, etc.) in the panel "Class Prediction" and the predicted bird species in the panel "Species Prediction". 
    * The audio types are predicted as multi-lable classification based on the AudioMAE model. The predicted classes indicate the possible presence of different types of audio in the recording.
    * The bird species are predicted as a multi-class classification using the selected model. The predicted classes indicate the most possible bird species present in the recording. 
5. The waveform and spectrogram of the audio clip are displayed in the respective panels.

**Notes:**
- For an unknown bird species, the model may predict the most similar bird species based on the training data.
- If an audio clip contains non-bird sounds (predicted by the AudioMAE), the bird species prediction may not be accurate.

**Disclaimer**: The model predictions are based on the training data and may not be accurate for all audio clips. The model is trained on a dataset of 728 bird species and may not generalize well to all bird species.

<div align="center">
  <b>Enjoy the Bird Songs! 🐦🎶
</div>
