package com.example.miwok;

import android.content.Context;


public class Word {
    // Default translation for the word
    private String mDefaultTranslation;

    // Miwok translation for the word
    private String mMiwokTranslation;

    // Image resource ID for the word
//    private int mImageResourceId; // 1st way
    private  int mImageResourceId = NO_IMAGE_PROVIDED;
    private static final int NO_IMAGE_PROVIDED = -1; // 2nd way

    private int mAudioResourceId;


    /**
     * Create a new Word object.
     *
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     */
    public Word(String defaultTranslation, String miwokTranslation, int audioResourceId) {
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mAudioResourceId = audioResourceId;
    }

    /**
     * Create a new Word object.
     * @param defaultTranslation is the word in a language that the user is already familiar with
     *      *                           (such as English)
     * @param miwokTranslation is the word in the Miwok language
     * @param imageResouceId is image in the Miwok language for corresponding image.
     * @param audioResourceId is the resource Id for the audio file associated with this word.
     */
    public Word(String defaultTranslation, String miwokTranslation, int imageResouceId, int audioResourceId){
        mDefaultTranslation = defaultTranslation;
        mMiwokTranslation = miwokTranslation;
        mImageResourceId = imageResouceId;
        mAudioResourceId = audioResourceId;

    }


    /**
     * Get the default translation of the word.
     */
    public String getDefaultTranslation() {
        return mDefaultTranslation;
    }

    /**
     * Get the Miwok translation of the word.
     */
    public String getMiwokTranslation() {
        return mMiwokTranslation;
    }

    /**
     * Get the Image ResourceID of the word.
     */
    public int getmImageResourceId(){
        return mImageResourceId;
    }

    public boolean hasImage(){
        return mImageResourceId != NO_IMAGE_PROVIDED;
    }

    /**
     * Return the audio resource ID of the word
     */
    public int getAudioResourceId(){
        return  mAudioResourceId;
    }

}
