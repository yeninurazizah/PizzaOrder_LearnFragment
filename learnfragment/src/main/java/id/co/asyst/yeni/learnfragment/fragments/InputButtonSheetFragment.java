package id.co.asyst.yeni.learnfragment.fragments;


import android.app.DatePickerDialog;
import android.content.Context;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import id.co.asyst.yeni.learnfragment.R;
import id.co.asyst.yeni.learnfragment.utility.DateUtils;

/**
 * A simple {@link Fragment} subclass.
 */
public class InputButtonSheetFragment extends BottomSheetDialogFragment implements View.OnClickListener, DatePickerDialog.OnDateSetListener {


    EditText nameET, alamatET;
    Button submitButton;
    InputButtonSheetFragment.OnSubmitButtonListener listener;
    TextView dateTV;
    ImageView dateImgView;
    DatePickerDialog datePickerDialog;

    public InputButtonSheetFragment() {
        // Required empty public constructor
    }

    public static InputButtonSheetFragment newInstance(String name, String address, String birthday) {
        InputButtonSheetFragment inputBottom = new InputButtonSheetFragment();
        //untuk menampilkan data dari activity ke fragment.
        Bundle bundle = new Bundle();
        bundle.putString("nama", name);
        bundle.putString("alamat", address);
        bundle.putString("date", birthday);

        inputBottom.setArguments(bundle);

        return inputBottom;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_input_button_sheet, container, false);

        nameET = view.findViewById(R.id.nama_edittext);
        alamatET = view.findViewById(R.id.alamat_edittext);
        submitButton = view.findViewById(R.id.submit_button);

        Calendar calendar = Calendar.getInstance();

        dateTV = view.findViewById(R.id.date_tv);
        dateImgView = view.findViewById(R.id.date_img_view);
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd MM yyyy");

        if (getArguments() != null) {
            nameET.setText(getArguments().getString("nama", ""));
            alamatET.setText(getArguments().getString("alamat", ""));
            dateTV.setText(getArguments().getString("date", ""));
        }

        int year = 2000;
        int month = 0;
        int day = 1;
        String selectedDate = dateTV.getText().toString();

        if (!selectedDate.equalsIgnoreCase("")) {
            calendar.setTime(DateUtils.dateFromString("dd MMMM yyyy", selectedDate));

            year = calendar.get(Calendar.YEAR);
            month = calendar.get(Calendar.MONTH);
            day = calendar.get(Calendar.DAY_OF_MONTH);
        }

        datePickerDialog = new DatePickerDialog(getActivity(), this, year, month, day);
        submitButton.setOnClickListener(this);
        dateImgView.setOnClickListener(this);

        return view;

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.submit_button:

                listener.onSubmitButton(nameET.getText().toString(), alamatET.getText().toString(), dateTV.getText().toString());

                dismiss();

                break;
            case R.id.date_img_view:
                datePickerDialog.show();
                break;
        }
    }

    @Override
    public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
        String date = dayOfMonth + " " + (month + 1) + " " + year;
        dateTV.setText(DateUtils.formatDate("dd MM yyyy", "dd MMMM yyyy", date));
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof InputButtonSheetFragment.OnSubmitButtonListener) {
            listener = (InputButtonSheetFragment.OnSubmitButtonListener) context;
        } else {
            throw new RuntimeException(context.toString() + "Activity harus implement interface");
        }


    }

    public interface OnSubmitButtonListener {
        void onSubmitButton(String name, String address, String birthday);
    }

}
