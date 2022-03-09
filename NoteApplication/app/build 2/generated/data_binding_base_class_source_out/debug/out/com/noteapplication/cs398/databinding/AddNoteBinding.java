// Generated by view binder compiler. Do not edit!
package com.noteapplication.cs398.databinding;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.SwitchCompat;
import androidx.viewbinding.ViewBinding;
import androidx.viewbinding.ViewBindings;
import com.google.android.material.textfield.TextInputEditText;
import com.noteapplication.cs398.R;
import java.lang.NullPointerException;
import java.lang.Override;
import java.lang.String;

public final class AddNoteBinding implements ViewBinding {
  @NonNull
  private final RelativeLayout rootView;

  @NonNull
  public final LinearLayout LinearLayoutButton;

  @NonNull
  public final RelativeLayout addpage;

  @NonNull
  public final AppCompatButton cancelButton;

  @NonNull
  public final TextInputEditText contentInput;

  @NonNull
  public final SwitchCompat idRmdSwitch;

  @NonNull
  public final AppCompatButton saveButton;

  @NonNull
  public final TextInputEditText titleInput;

  private AddNoteBinding(@NonNull RelativeLayout rootView, @NonNull LinearLayout LinearLayoutButton,
      @NonNull RelativeLayout addpage, @NonNull AppCompatButton cancelButton,
      @NonNull TextInputEditText contentInput, @NonNull SwitchCompat idRmdSwitch,
      @NonNull AppCompatButton saveButton, @NonNull TextInputEditText titleInput) {
    this.rootView = rootView;
    this.LinearLayoutButton = LinearLayoutButton;
    this.addpage = addpage;
    this.cancelButton = cancelButton;
    this.contentInput = contentInput;
    this.idRmdSwitch = idRmdSwitch;
    this.saveButton = saveButton;
    this.titleInput = titleInput;
  }

  @Override
  @NonNull
  public RelativeLayout getRoot() {
    return rootView;
  }

  @NonNull
  public static AddNoteBinding inflate(@NonNull LayoutInflater inflater) {
    return inflate(inflater, null, false);
  }

  @NonNull
  public static AddNoteBinding inflate(@NonNull LayoutInflater inflater, @Nullable ViewGroup parent,
      boolean attachToParent) {
    View root = inflater.inflate(R.layout.add_note, parent, false);
    if (attachToParent) {
      parent.addView(root);
    }
    return bind(root);
  }

  @NonNull
  public static AddNoteBinding bind(@NonNull View rootView) {
    // The body of this method is generated in a way you would not otherwise write.
    // This is done to optimize the compiled bytecode for size and performance.
    int id;
    missingId: {
      id = R.id.LinearLayoutButton;
      LinearLayout LinearLayoutButton = ViewBindings.findChildViewById(rootView, id);
      if (LinearLayoutButton == null) {
        break missingId;
      }

      RelativeLayout addpage = (RelativeLayout) rootView;

      id = R.id.cancel_button;
      AppCompatButton cancelButton = ViewBindings.findChildViewById(rootView, id);
      if (cancelButton == null) {
        break missingId;
      }

      id = R.id.content_input;
      TextInputEditText contentInput = ViewBindings.findChildViewById(rootView, id);
      if (contentInput == null) {
        break missingId;
      }

      id = R.id.idRmdSwitch;
      SwitchCompat idRmdSwitch = ViewBindings.findChildViewById(rootView, id);
      if (idRmdSwitch == null) {
        break missingId;
      }

      id = R.id.save_button;
      AppCompatButton saveButton = ViewBindings.findChildViewById(rootView, id);
      if (saveButton == null) {
        break missingId;
      }

      id = R.id.title_input;
      TextInputEditText titleInput = ViewBindings.findChildViewById(rootView, id);
      if (titleInput == null) {
        break missingId;
      }

      return new AddNoteBinding((RelativeLayout) rootView, LinearLayoutButton, addpage,
          cancelButton, contentInput, idRmdSwitch, saveButton, titleInput);
    }
    String missingId = rootView.getResources().getResourceName(id);
    throw new NullPointerException("Missing required view with ID: ".concat(missingId));
  }
}
