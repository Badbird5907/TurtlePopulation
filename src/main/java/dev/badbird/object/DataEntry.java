package dev.badbird.object;

import com.opencsv.bean.CsvBindByName;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class DataEntry {
    //dataset_id	row_id	latitude	longitude	species_name	scientific_name	common_name	itis_tsn	group_size	series_id	date_time	timezone	ds_type	platform	provider	lprecision	tprecision	oceano	notes	last_mod
    @CsvBindByName
    private int dataset_id;
    @CsvBindByName
    private String row_id;
    @CsvBindByName
    private double latitude;
    @CsvBindByName
    private double longitude;
    @CsvBindByName
    private String species_name;
    @CsvBindByName
    private String scientific_name;
    @CsvBindByName
    private String common_name;
    @CsvBindByName
    private int itis_tsn;
    @CsvBindByName
    private int group_size;
    @CsvBindByName
    private String series_id;
    @CsvBindByName
    private String date_time;
    @CsvBindByName
    private String timezone;
    @CsvBindByName
    private String ds_type;
    @CsvBindByName
    private String platform;
    @CsvBindByName
    private String provider;
    @CsvBindByName
    private int lprecision;
    @CsvBindByName
    private int tprecision;
    @CsvBindByName
    private String oceano;
    @CsvBindByName
    private String notes;
    @CsvBindByName
    private String last_mod;

    @Override
    public String toString() {
        return "DataEntry{" +
                "dataset_id=" + dataset_id +
                ", row_id=" + row_id +
                ", latitude=" + latitude +
                ", longitude=" + longitude +
                ", species_name='" + species_name + '\'' +
                ", scientific_name='" + scientific_name + '\'' +
                ", common_name='" + common_name + '\'' +
                ", itis_tsn=" + itis_tsn +
                ", group_size=" + group_size +
                ", series_id='" + series_id + '\'' +
                ", date_time='" + date_time + '\'' +
                ", timezone='" + timezone + '\'' +
                ", ds_type='" + ds_type + '\'' +
                ", platform='" + platform + '\'' +
                ", provider='" + provider + '\'' +
                ", lprecision=" + lprecision +
                ", tprecision=" + tprecision +
                ", oceano='" + oceano + '\'' +
                ", notes='" + notes + '\'' +
                ", last_mod='" + last_mod + '\'' +
                '}';
    }
}
