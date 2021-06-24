# Bachelors Thesis Contribution Viktor Gsteiger

This repository contains some parts of the contribution of the Bachelors thesis of Viktor Gsteiger which was worked on during the 1st of March until the 30th of June 2021.

## Abstract

Expressing a temporal relationship between different search queries has become more important in recent years, especially when working with extensive video and audio data collections. Enabling queries with such a relationship is achieved by using temporal queries processed by temporal scoring algorithms. These algorithms aggregate the result sets of multiple search queries according to a temporal relationship and score the results regarding the similarity to the temporal query. In this thesis, seven such algorithms were developed and evaluated regarding response time and searched-item ranking as the primary metrics using a dataset of 109 queries specifically developed to test temporal query algorithms and specified in a newly developed format. The two best-performing algorithms were subsequently implemented in vitrivr, a multimedia retrieval system, with changes to both the front-end and the back-end. The implementation was afterwards successfully used during a competitive evaluation of interactive multimedia retrieval systems. The competitive evaluation has shown that temporal querying in vitrivr has noticeably improved with regards to response time and searched-item ranking due to the new algorithms and the new implementation within vitrivr.


## Evaluation application

The evaluation application described during the thesis can be found [here](tempAlgEval/). We can run the application with the following command:

```console
foo@bar:~$ ./gradlew run
```

## Resources

During the thesis we referenced to evaluation results as well as a full specification file. All those files can be found in the subfolder [Results](Results/). The specification file can be read by the evaluation application. A full definition of the specification file can be seen [here](Results/specification_definition.json).

## Thesis

The thesis can be found [here](Thesis.pdf)
