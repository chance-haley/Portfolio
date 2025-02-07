import numpy
from keras.datasets import imdb
from keras.datasets import Sequential
from keras.layers import Dense
from keras.layers import LSTM
from keras.layers.embeddings import Embedding
from keras.preprocessing import sequence

top_words = 5000
(X_train, y_train), (X_test, y_test) = imdb.load_data(num_words = top_words)

max_review_length = 500
X_train = sequence.pad_sequences(X_train, maxlen = max_review_length)
X_test = sequence.pad_sequences(X_test, maxlen = max_review_length)

embedding_vector_length = 32
model = Sequential()
model.add(Embedding(top_words, embedding_vector_length, input_length = max_review_length))
model.add(LSTM(100))
model.add(Dense(1, activation = "sigmoid"))
model.compile(loss = "binary_crossentropy", optimizer = "adam", metrics = ["accuracy"])
print(model.summary())
model.fit(X_train, y_train, epochs = 3, batch_size = 64)

# Read through the summary. It shows the configuration and the training result.


# Test the model.
scores = model.evaluate(X_test, y_test, verbose = 0)
print("accuracy: %.2f%%" % (scores[1]*100))
Model: "sequential_2"


# NEXT: Use the following command to load the CIFAR-10 dataset and build an LSTM model to 
# train, validate, and eventually test your model to classify CIFAR images.
# Report the performance of your model.

keras.datasets.cifar10.load_data()
