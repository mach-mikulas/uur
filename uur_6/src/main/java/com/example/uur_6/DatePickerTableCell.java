package com.example.uur_6;

import javafx.scene.Node;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

public class DatePickerTableCell<S, T> extends TableCell<S, LocalDate> {

    private DateTimeFormatter dateString = DateTimeFormatter.ofLocalizedDate(FormatStyle.FULL);
    private DatePicker editor;

    //public static <S> CallBack<TableColumn>{

    }

    public DatePickerTableCell(){
        super();

        editor = new DatePicker();
        editor.setOnAction(e->commitEdit(editor.getValue()));
    }

    @Override
    public void cancelEdit(){
        super.cancelEdit();

        setGraphic(null);
        setText(createRendererContent(getItem()));
    }

    public void commitEdit(LocalDate newDate){
        super.commitEdit(newDate);

        setGraphic(null);
        setText(createRendererContent(getItem()));
    }

    public void startEdit(){
        super.startEdit();

        editor.valueProperty();

        setText("");
        setGraphic(editor);
    }

    private String createRendererContent(LocalDate date){
        if (date != null){
            return dateString.format(getItem());
        }
        else{
            return "data not set";
        }
    }

    @Override
    public void updateItem(LocalDate date, boolean empty){
        super.updateItem(date,empty);

        if(empty){
            //setText("Nothing to se here");
        }
        else{
            if(date != null){
                setText(dateString.format(date));
                //setText(String.valueOf(date));
            }
            else{
                setText("Date not set");
            }
        }
    }
}
