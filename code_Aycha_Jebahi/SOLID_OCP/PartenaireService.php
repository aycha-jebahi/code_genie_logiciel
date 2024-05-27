<?php
class PartenaireService implements PartenaireServiceInterface
{
    public function getAllPartenaires()
    {
        return Partenaire::all();
    }
}
