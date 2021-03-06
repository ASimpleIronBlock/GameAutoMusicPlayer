package me.ironblock.automusicplayer.note;

import java.util.Objects;

/**
 * @author :Iron__Block
 * @Date :2022/1/15 23:10
 */

public class NoteInfo {
    /**
     * The octave of the note
     */
    public int octave;
    /**
     * The name of the note
     */
    public int note;
    /**
     * if the note is expressed with vk code
     */
    public boolean isVKCode;
    /**
     * the vk code of the note, if isVKCode is false,this will be 0
     */
    public int vk_Code;

    public NoteInfo(boolean isVkCode, int vk_Code) {
        this.isVKCode = isVkCode;
        this.vk_Code = vk_Code;
    }

    public NoteInfo(int octave, int note) {
        this.octave = octave;
        this.note = note;
    }

    public NoteInfo(int noteIndex) {
        this((noteIndex / 12), noteIndex % 12);
    }

    public int getNoteIndex() {
        return octave * 12 + note;
    }

    public void addKey(int key) {
        int tmp = octave * 12 + note + key;
        octave = tmp / 12;
        note = tmp % 12;
    }

    public void increaseOneKey() {
        note++;
        if (note >= 12) {
            octave++;
            note -= 12;
        }
    }

    public void decreaseOnKey() {
        note--;
        if (note < 0) {
            octave--;
            note += 12;
        }
    }


    public boolean isVKCode() {
        return isVKCode;
    }

    public int getVk_Code() {
        return vk_Code;
    }

    @Override
    public String toString() {
        return "NoteInfo{" + "octave=" + octave + ", note=" + note + '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o)
            return true;
        if (o == null || getClass() != o.getClass())
            return false;
        NoteInfo noteInfo = (NoteInfo) o;
        return octave == noteInfo.octave && note == noteInfo.note && noteInfo.vk_Code == vk_Code;
    }

    @Override
    public int hashCode() {
        return Objects.hash(octave, note, vk_Code);
    }
}
