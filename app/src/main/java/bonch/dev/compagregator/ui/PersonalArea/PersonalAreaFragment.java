package bonch.dev.compagregator.ui.PersonalArea;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import bonch.dev.compagregator.R;

public class PersonalAreaFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {

        View root = inflater.inflate(R.layout.fragment_personal_area, container, false);
        final TextView textView = root.findViewById(R.id.text_notifications);
        return root;
    }
}