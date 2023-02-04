package com.example.miwok;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.core.content.ContextCompat;

import java.util.ArrayList;

public class WordAdapter extends ArrayAdapter<Word> {
    /*
     * {@link AndroidFlavorAdapter} is an {@link ArrayAdapter} that can provide the layout for each list
     * based on a data source, which is a list of {@link AndroidFlavor} objects.
     * */

    /** Resource ID for the background color for this list of words */
    private int mColorResourceId;

    private static final String LOG_TAG = WordAdapter.class.getSimpleName();
    /**
     * This is our own custom constructor (it doesn't mirror a superclass constructor).
     * The context is used to inflate the layout file, and the list is the data we want
     * to populate into the lists.
     *
     * @param context        The current context. Used to inflate the layout file.
     * @param words A List of AndroidFlavor objects to display in a list
     */
    public WordAdapter(Activity context, ArrayList<Word> words, int colorResourceId){
        // Here, we initialize the ArrayAdapter's internal storage for the context and the list.
        // the second argument is used when the ArrayAdapter is populating a single TextView.
        // Because this is a custom adapter for two TextViews and an ImageView, the adapter is not
        // going to use this second argument, so it can be any value. Here, we used 0.
        super(context,0,words);
        mColorResourceId = colorResourceId;
    }
    /**
     * Provides a view for an AdapterView (ListView, GridView, etc.)
     *
     * @param position The position in the list of data that should be displayed in the
     *                 list item view.
     * @param convertView The recycled view to populate.
     * @param parent The parent ViewGroup that is used for inflation.
     * @return The View for the position in the AdapterView.
     */
    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        // Check if the existing view is being reused, otherwise inflate the view
        View listItemView = convertView;
        if(listItemView == null) {
            listItemView = LayoutInflater.from(getContext()).inflate(
                    R.layout.list_item, parent, false);
        }

        /**
         * Get the {@link AndroidFlavor} object located at this position in the list
         */
        Word currentWord = getItem(position);
//        Word currentImage = getItem(position);

        // Find the TextView in the list_item.xml layout with the ID version_name
        TextView miwokTextView = (TextView) listItemView.findViewById(R.id.miwok_text_view);
        // Get the version name from the current Word object and
        // set this text on the name TextView
        miwokTextView.setText(currentWord.getMiwokTranslation());

        // Find the TextView in the list_item.xml layout with the ID version_number
        TextView defaultTextView = (TextView) listItemView.findViewById(R.id.default_text_view);
        // Get the version number from the current Word object and
        // set this text on the number TextView
        defaultTextView.setText(currentWord.getDefaultTranslation());

        // Find the ImageView in the list_item.xml layout with the ID version_image
        ImageView charImageView = listItemView.findViewById(R.id.image);
        //Get the version number from the current Word object and
        //set this text on the image ImageView
//        This is 1st way it is same as the second way.
//        charImageView.setImageResource(currentWord.getmImageResourceId());

        // check if an image is available, display the provided image based on the resource ID
        if(currentWord.hasImage()){
            // if an image is available, display the provided image based on the resource ID
            charImageView.setImageResource(currentWord.getmImageResourceId());
            //Make sure the view is visible
            charImageView.setVisibility(View.VISIBLE);
        }
        else{
            // otherwise hide the imageView (set visibility to GONE)
            charImageView.setVisibility(View.GONE);
        }
        //set the theme color of the list item
        View textContainer = listItemView.findViewById(R.id.text_container);
        // find the color that the resource Id maps to
        int color = ContextCompat.getColor(getContext(), mColorResourceId);
        // set the background color of the text container View
        textContainer.setBackgroundColor(color);

        // Return the whole list item layout (containing 2 TextViews)
        // so that it can be shown in the ListView
        return listItemView;
//        return super.getView(position, convertView, parent);
    }
}
