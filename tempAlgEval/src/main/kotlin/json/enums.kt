package json

/**
 * Collection of Enums to be used throughout this application. Mostly for the translation from specification to Cineast internal data types.
 */

enum class TaskType {
    KIST,
    KISV
}

enum class MessageType {
    M_LOOKUP,
    PING,
    Q_MLT,
    Q_NESEG,
    Q_SIM,
    SESSION_START
}

enum class Hints {
    exact,
    inexact,
    lsh,
    ecp,
    mi,
    pq,
    sh,
    va,
    vaf,
    vav,
    sequential,
    empirical
}

enum class QueryTermType {
    IMAGE,
    TEXT,
    TAG,
    SEMANTIC,
    UNINITIATED
}

enum class VBSCategories {
    text,
    image,
    sketch,
    filter
}

enum class VBSTypes {
    metadata,
    OCR,
    ASR,
    concept,
    localizedObject,
    caption,
    jointEmbedding,
    custom,
    globalFeatures,
    localFeatures,
    feedbackModel,
    color,
    edge,
    motion,
    semanticSegmentation,
    BW,
    dominantColor,
    resolution,
    numberOfObjects,
    visualtextcoembedding
}

enum class Categories {
    semantic,
    globalcolor,
    localcolor,
    edge,
    quantized,
    tags,
    ocr,
    asr,
    scenecaption,
    visualtextcoembedding
}

enum class MediaType {
    VIDEO, IMAGE, AUDIO, MODEL3D, UNKNOWN
}

enum class EvaluationMetrics {
    VBS2019
}

enum class ScoringAlgorithm
